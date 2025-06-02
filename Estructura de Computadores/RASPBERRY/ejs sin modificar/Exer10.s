/* Basic skeleton for programs using ports (without interruptions) */

.include "configuration.inc" 
.include "symbolic.inc"

/* Stack init for SVC mode	*/
	mov     r0, #0b11010011
	msr     cpsr_c, r0
	mov     sp, #0x8000000
	
/* Continue my program here */

	ldr r0, =GPBASE
	ldr r1,= 0x010

x:	ldr r2,[r0,#GPLEV0]
	tst r2,#0b00100
	beq loop1
	
	ldr r4,[r0,#GPLEV0]
	tst r4,#0b01000
	beq loop2
	
	b x

loop1:	str r1,[r0,#GPSET0]
		BL wait1
		str r1,[r0,#GPCLR0]
		BL wait1
		B loop1

loop2:	str r1,[r0,#GPSET0]
		BL wait2
		str r1,[r0,#GPCLR0]
		BL wait2
		B loop2

wait1:	ldr r7,=STBASE
		ldr r3,[r7,#STCLO]
		ldr r4,=3816
		add r4,r4,r3
		
		ret1:		ldr r3,[r7,#STCLO]
				cmp r3,r4
				blt ret1
				bx lr

wait2:	ldr r7,=STBASE
		ldr r3,[r7,#STCLO]
		ldr r4,=2557
		add r4,r4,r3
		
		ret2:		ldr r3,[r7,#STCLO]
				cmp r3,r4
				blt ret2
				bx lr


end:   b end
