/* Basic skeleton for programs using interrupts */

.include "configuration.inc"
.include "symbolic.inc"

/* Vector Table inicialization */
mov r0,#0
ADDEXC 0x1C, fast_interrupt      @only if used

/* Stack init for FIQ mode */
mov     r0, #0b11010001
msr     cpsr_c, r0
mov     sp, #0x4000
mov r8,#0
/* Stack init for SVC mode */
mov     r0, #0b11010011
msr     cpsr_c, r0
mov     sp, #0x8000000

/* Continue my program here */

@Programa que enciende en cadena (0,25s) todos los leds en un bucle infinito
	
	@Preparing C3 to send an interrupt after "y" microseconds
    ldr r0, =STBASE
	ldr r1,[r0,#STCLO]
	ldr r7,=250000			
	add r1,r1,r7
	str r1,[r0,#STC3]
	
	@Enable FIQ
	ldr r0, =INTBASE
	ldr r1,=0x83
	str r1,[r0,#INTFIQCON]
	
	@Enable FIQ (SVC mode)
	mov r1,#0b10010011
	msr cpsr_c,r1

	mov r7, #6

end:    b end

/* Fast interrupt (only if used) */
fast_interrupt:
push {r0-r6}

	ldr r0,=GPBASE
	ldr r6, =0x08000000			
	ldr r5,=0x00400000
	ldr r4,=0x20000
	ldr r3,=0x800
	ldr r2,=0x400
	ldr r1,=0x200
       
       cmp r7,#6				@si contador=6 enciende r1 y apaga r6
       streq r1,[r0,#GPSET0]
       streq r6,[r0,#GPCLR0]
       
       cmp r7,#5
       streq r2,[r0,#GPSET0]
       streq r1,[r0,#GPCLR0]
       
       cmp r7,#4
       streq r3,[r0,#GPSET0]
       streq r2,[r0,#GPCLR0]
       
       cmp r7,#3
       streq r4,[r0,#GPSET0]
       streq r3,[r0,#GPCLR0]
       
       cmp r7,#2
       streq r5,[r0,#GPSET0]
       streq r4,[r0,#GPCLR0]
       
       cmp r7,#1
       streq r6,[r0,#GPSET0]
       streq r5,[r0,#GPCLR0]
       
       sub r7,r7,#1				@va disminuyendo el contador
       
       cmp r7,#0				@si es 0 vuelve a ponerlo en 6 para empezar de nuevo
       moveq r7,#6
	   
	@Reset (end) of the timer interrupt by comparator C3
    ldr r0, =STBASE				
	mov r1,#0b01000
	str r1,[r0,#STCS]
	
	@Preparing C3 to send an interrupt after "y" microseconds
	ldr r0, =STBASE
	ldr r1,[r0,#STCLO]
	ldr r8,=250000
	add r1,r1,r8
	str r1,[r0,#STC3]

	pop { r0-r6}
	subs  pc, lr, #4
	
	
	
	
	