/* Basic skeleton for programs using interrupts */

.include "configuration.inc" 
.include "symbolic.inc"

/* Vector Table inicialization */
	mov r0,#0
	ADDEXC 0x1C, fast_interrupt      @only if used


/* Stack init for IRQ mode */	
	mov     r0, #0b11010010   
	msr     cpsr_c, r0
	mov     sp, #0x8000
/* Stack init for FIQ mode */	
	mov     r0, #0b11010001
	msr     cpsr_c, r0
	mov     sp, #0x4000
		mov r8,#0
/* Stack init for SVC mode	*/
	mov     r0, #0b11010011
	msr     cpsr_c, r0
	mov     sp, #0x8000000
	
/* Continue my program here */

	ldr r0,=STBASE
	ldr r1,[r0,#STCLO]
	add r1,#0x20000
	str r1,[r0,#STC3]
	
	ldr r0, =INTBASE
	ldr r1,=0x083
	str r1,[r0,#INTFIQCON]
	
	mov r1,#0b10010011
	msr cpsr_c, r1
	
	mov r7,#0

end:   nop
	nop
	b end


/* Fast interrupt (only if used) */
fast_interrupt: 
	push {r0,r1}
	
	@encendemos si r7 = 1
	@apagamos si r7=0
	
	ldr r0,=GPBASE
	ldr r1,=0x400000 @verde
	eors r7,#1
	streq r1,[r0,#GPSET0]
	strne r1,[r0,#GPCLR0]
	
	@aqui queremos preparar el programa para que pueda haber otro interrupt
	
	ldr r0,=STBASE
	mov r1,#0b01000 @#0b0010 si estuvieramos en c1
	str r1,[r0,#STCS]
	
	@tenemos que poner la espera de nuevo porque volvemos a end, no al principio del programa
	
	ldr r0,=STBASE
	mov r1,#0b01000 @#0b0010 si estuvieramos en c1
	str r1,[r0,#STCS]
	
	ldr r0,=STBASE
	ldr r1,[r0,#STCLO]
	add r1,#0x20000
	str r1,[r0,#STC3]

	pop {r0,r1,r2}
	subs  pc, lr, #4
