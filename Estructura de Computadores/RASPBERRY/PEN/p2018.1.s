/* Basic skeleton for programs using ports (without interruptions) */

.include "configuration.inc" 
.include "symbolic.inc"

/* Stack init for SVC mode	*/
	mov     r0, #0b11010011
	msr     cpsr_c, r0
	mov     sp, #0x8000000
	
/* Continue my program here */

	ldr r0, =GPBASE
	ldr r2, =0x8020400 @All leds
	str r2,[r0,#GPSET0]
	
	ldr r5, =0x200     			@Red led 1
	ldr r6, =0x400     			@Red led 2
	ldr r8, =0x800     			@Yellow led 1
	ldr r9, =0x20000       		@Yellow led 2
	ldr r10, =0x00400000       	@Green led 1
	ldr r11, =0x08000000       	@Green led 2
	
	ldr r1,[r0,#GPLEV0]
	tst r1,#0b00100				@pulsado
	ldr r4,=200000
	bl wait1
	streq r5,[r0,#GPCLR0]
	ldr r4,=200000
	bl wait1
	streq r6,[r0,#GPCLR0]
	ldr r4,=200000
	bl wait1
	streq r8,[r0,#GPCLR0]
	ldr r4,=200000
	bl wait1
	streq r9,[r0,#GPCLR0]
	ldr r4,=200000
	bl wait1
	srteq r10,[r0,#GPCLR0]
	ldr r4,=200000
	bl wait1
	streq r11,[r0,#GPCLR0]
	
	ldr r12,=0x010
	str r12,[r0,#GPSET0]
	bl wait2
	str r12,[r0,#GPCLR0]
	bl wait2

wait1:	ldr r7,=STBASE
		ldr r3,[r7,#STCLO]
		add r4,r3,r4 
		ret1:	ldr r3,[r7,#STCLO]
				cmp r3,r4 
				blt ret1 
				bx lr 

wait2:	ldr r7,=STBASE
		ldr r3,[r7,#STCLO]
		ldr r4,=500
		add r4,r3,r4
		
end:   b end



