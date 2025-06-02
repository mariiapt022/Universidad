/*@OBJECTIVE: configurar C1 comparator y depues de 2 segundos, la handler routine enciende luz amarilla*/

/* Basic skeleton for programs using interrupts */

.include "configuration.inc" 
.include "symbolic.inc"

/* Vector Table inicialization */
	mov r0,#0

	ADDEXC 0x18, regular_interrupt @only if used


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

	ldr r0, =STBASE
	ldr r1, [r0, #STCLO]
	add r1, #0x200000   @y microseconds
	str r1, [r0, #STC1]
	
	@diapositiva 14
	
	ldr r0,=INTBASE
	mov r1, #0b0010 @0b1000 si fuera C3
	str r1,[r0,#INTENIRQ1]
		
	mov r1, #0b01010011
	msr cpsr_c, r1

end:   b end




regular_interrupt:

	push {r0,r1}

	@aquí encendemos la luz

	ldr r0, = GPBASE
	ldr r1, =0x30800 @led amarillo
	str r1, [r0, #GPSET0]

	

	ldr r0, =STBASE
	ldr r2, [r0, #STCS]
	tst r2,#0b0010

	@aquí preparamos el programa para que pueda haber otro interrupt

	ldr r0, =GPBASE
	mov r1, #0b0010

	str r1,[r0,#GPEDS0]

	pop {r0,r1}
	subs pc, lr, #4
