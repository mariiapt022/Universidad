/* Basic skeleton for programs using ports (without interruptions) */

.include "configuration.inc" 
.include "symbolic.inc"

/* Stack init for SVC mode	*/
	mov     r0, #0b11010011
	msr     cpsr_c, r0
	mov     sp, #0x8000000
	
/* Continue my program here */

	ldr r0, =GPBASE
x:
	ldr r1,=0x800
	ldr r4,=0xE000000
	
	ldr r2,[r0,#GPLEV0]
	tst r2,#0b00100
	streq r1,[r0,#GPSET0]
	
	ldr r3,[r0,#GPLEV0]
	tst r3,#0b01000
	streq r4,[r0,#GPSET0]
	b x

end: b end