/*@OBJECTIVE: configurar C1 comparator y depues de 2 segundos, la handler routine enciende luz amarilla*/

/* Basic skeleton for programs using interrupts */

.include "configuration.inc" 
.include "symbolic.inc"

/* Vector Table inicialization */
	mov r0,#0
	ADDEXC 0x18, regular_interrupt 

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

@Programa que utiliza C1 y dsps de 2 segundos produce un IQR y enciende las
@leds amarillas

	@Preparing C1 to send an interrupt after "y" microseconds
	ldr r0, =STBASE
	ldr r1, [r0, #STCLO]
	add r1, #0x200000   	@y microseconds
	str r1, [r0, #STC1]		@#STC3 for C3
	
	
	@Enable local interrupt IRQ?
	ldr r0,=INTBASE
	mov r1, #0b0010 		@0b1000 si fuera C3
	str r1,[r0,#INTENIRQ1]
	
	@Enable global interrupt IRQ (for SVC mode)
	mov r1, #0b01010011
	msr cpsr_c, r1

end:   b end


regular_interrupt:

	push {r0,r1}

	ldr r0, = GPBASE
	ldr r1, =0x30800 		@led amarillo
	str r1, [r0, #GPSET0]	@enciende

	ldr r0, =STBASE			@boton 1
	ldr r2, [r0, #STCS]		
	tst r2,#0b0010

	@aquí preparamos el programa para que pueda haber otro interrupt
	@Reset (end) of interrupt IRQ2 (GPIO2&3) to allow a new interrupt via GPIO2&3
	ldr r0, =GPBASE
	mov r1, #0b0010
	str r1,[r0,#GPEDS0]

	pop {r0,r1}
	subs pc, lr, #4			@Return
	
	
	
