/*ALL LEDS sequence AND SOUND by using REGULAR and FAST INTERRUPT  WITH  TIMER  c3 and c1*/
/* El periodo sera de 2s para los leds y 500ms para sonido*/
/* Basic skeleton for programs using interrupts */

.include "configuration.inc" 
.include "symbolic.inc"

/* 1 Vector Table inicialization */
	mov r0,#0
	ADDEXC 0x18, regular_interrupt @only if used
	ADDEXC 0x1C, fast_interrupt      @only if used

/* 2 Stack init for IRQ mode */	
	mov     r0, #0b11010010   
	msr     cpsr_c, r0
	mov     sp, #0x8000
/* 2 Stack init for FIQ mode */	
	mov     r0, #0b11010001
	msr     cpsr_c, r0
	mov     sp, #0x4000
		mov r8,#0
/* 3 Stack init for SVC mode	*/
	mov     r0, #0b11010011
	msr     cpsr_c, r0
	mov     sp, #0x8000000
	
/* Continue my program here */

@Programa que enciende en cadena los leds (2s) (C1)(IRQ) y mientras suena un sonido
@distinto por cada led (0,5s)(C3)(FIQ)

	/* 5 The peripheral interrupt is the timer*/
	ldr r0, =STBASE
	ldr r1, [r0, #STCLO]
	ldr r2, =500000
	add r1, r2, r1    @y microseconds
	str r1, [r0, #STC3]
	
	ldr r0, =STBASE
	ldr r1, [r0, #STCLO]
	ldr r2, =500000
	add r1, r2, r1    @y microseconds
	str r1, [r0, #STC1]
	
	
	/* 6 Enable local FIQ */
	ldr r0, =INTBASE
	ldr r1, =0x083
	str r1, [r0, #INTFIQCON]
	
	/* 6 Enable local IRQ */
	ldr r0,=INTBASE
	mov r1, #0b0010 @(#0b1000 for C3)
	str r1,[r0,#INTENIRQ1]
	
	/* 7 Enable global FIQ and IRQ in svc mode */
	mov r1, #0b00010011
	msr cpsr_c, r1
	

/* 8 infinite loop*/
	mov r7, #0
	mov r6, #0
end:  b end

/* Regular interrupt (only if used)*/
regular_interrupt: 
	push {r0,r1}
	/* 3 programita */
	ldr r0, =GPBASE
	ldr r1, =0x8420E00 @ all led
	str r1,[r0, #GPCLR0] @ los apagamos todos
	
	cmp r7, #0
	ldreq r1, =0x200
	addeq r7, #1
	beq encender
	
	cmp r7, #1
	ldreq r1, =0x400
	addeq r7, #1
	beq encender
	
	cmp r7, #2
	ldreq r1, =0x800
	addeq r7, #1
	beq encender
	
	cmp r7, #3
	ldreq r1, =0x20000
	addeq r7, #1
	beq encender
	
	cmp r7, #4
	ldreq r1, =0x400000
	addeq r7, #1
	beq encender
	
	cmp r7, #5
	ldreq r1, =0x8000000
	ldreq r7, =0
	
encender: str r1,[r0, #GPSET0]
			
	/* 4 reset the timer */
	ldr r0, =STBASE
	mov r1, #0b0010 @for c3 #0b0010 for C1!!!
	str r1,[r0,#STCS]
	
	ldr r1, [r0, #STCLO]
	ldr r2, =500000
	add r1, r2, r1    @y microseconds
	str r1, [r0, #STC1]
	
	pop {r0,r1}
	subs  pc, lr, #4


/* Fast interrupt (only if used) */
fast_interrupt: 
	push { r0,r1}

	/* 3 programita */
	ldr r0, =GPBASE
	
	cmp r7, #0
	ldreq r4, =1984
	beq sonar
	
	cmp r7, #1
	ldreq r4, =1706
	beq sonar
	
	cmp r7, #2
	ldreq r4, =1515
	beq sonar
	
	cmp r7, #3
	ldreq r4, =1432
	beq sonar
	
	cmp r7, #4
	ldreq r4, =1275
	beq sonar
	
	cmp r7, #5
	ldreq r4, =1136
	
	
sonar: ldr r0, =GPBASE
	ldr r1, =0x010 @( =0b010000)
	eors r6, #1
	streq r1,[r0, #GPSET0]
	strne r1,[r0, #GPCLR0]
			
	/* 4 reset the timer */
	ldr r0, =STBASE
	mov r1, #0b01000 @for c3 #0b0010 for C1!!!
	str r1,[r0,#STCS]
	
	ldr r1, [r0, #STCLO]
	add r1, r4, r1    @y microseconds
	str r1, [r0, #STC3]
	
	pop { r0,r1}
	subs  pc, lr, #4