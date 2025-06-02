/* Basic skeleton for programs using ports (without interruptions) */

.include "configuration.inc" 
.include "symbolic.inc"

/* Stack init for SVC mode	*/
	mov     r0, #0b11010011
	msr     cpsr_c, r0
	mov     sp, #0x8000000
	
/* Continue my program here */
	
	ldr r0, =GPBASE
	ldr r2, =0x800     @Yellow led 1
	ldr r5, =0x600     @Red led 2
	ldr r6, =0x        @Green led
	ldr r8, =0x010	   @Speaker
	str r2,[r0,#GPSET0]

loop:	ldr r1,[r0,#GPLEV0]
	tst r1,#0b00100
	streq r5,[r0,#GPSET0]

	ldr r1,[r0,#GPLEV0]
	tst r1,#0b01000
	streq r8,[r0,#GPSET0]
	bl wait 
	streq r6,[r0,#GPSET0]
	b loop


wait: 	ldr r7,=STBASE
		ldr r3,[r7,#STCLO]
		ldr r4,=250
		add r4,r3,r4
		
		ret1:	ldr r3,[r7,#STCLO]
				cmp r3,r4
				blt ret1
				bx lr

end:   b end
