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
	
	ldr r0,=GPBASE
	ldr r1,=0x0200
	ldr r2,=0x0400
	str r1,[r0,#GPSET0]
	str r2,[r0,#GPSET0]
	
	ldr r0,=GPBASE
	mov r1,#0b01100
	str r1,[r0,#GPFEN0]
	
	ldr r0,=INTBASE
	ldr r1,=0x00100000
	str r1,[r0,#INTENIRQ2]
	
	mov r1,#0b01010011
	msr cpsr_c, r1


end:   b end

/* Regular interrupt (only if used) */
regular_interrupt: 
	push {r0,r1}
	ldr r0,=GPBASE
	ldr r1,[r0,#GPEDS0]
	tst r1,#0b00100
	
	ldr r2,=0x0200
	ldr r3,=0x0400
	
	strne r3,[r0,#GPCLR0]
	
	tst r1,#0b01000
	strne r2,[r0,#GPCLR0]
	
	ldr r0,=GPBASE
	mov r1, #0b01100
	str r1,[r0,#GPEDS0]
	

	pop {r0,r1}
	subs  pc, lr, #4


