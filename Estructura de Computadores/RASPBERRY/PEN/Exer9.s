/* Basic skeleton for programs using ports (without interruptions) */

.include "configuration.inc" 
.include "symbolic.inc"

/* Stack init for SVC mode	*/
	mov     r0, #0b11010011
	msr     cpsr_c, r0
	mov     sp, #0x8000000
	
/* Continue my program here */

@Programa que enciende las luces verdes 1s, 500ms, 250ms

	ldr r0, =GPBASE
	ldr r1,=0xE000D00
	
loop: str r1,[r0,#GPSET0]		@enciende
	BL wait1					@espera 1s
	str r1,[r0,#GPCLR0]			@apaga
	BL wait1					@espera 1s
	str r1,[r0,#GPSET0]
	BL wait2					@espera 0,5
	str r1,[r0,#GPCLR0]
	BL wait2					@espera 0,5
	str r1,[r0,#GPSET0]
	BL wait3					@espera 0,25
	str r1,[r0,#GPCLR0]
	BL wait3					@espera 0,25
	B loop

wait1: 	ldr r7,=STBASE			@r7=0x3F003004 (address of counter CLO)	
		ldr r3,[r7,#STCLO]		@read the value of the counter
		ldr r4,=1000000			@r4=1000000 mu s
		add r4,r4,r3			@adding to the current count to get the final count
		ret1: ldr r3,[r7,#STCLO]@read the current count
			cmp r3,r4			@comparing current count with the final count
			blt ret1
			bx lr
			
wait2: 	ldr r7,=STBASE
		ldr r3,[r7,#STCLO]
		ldr r4,=500000
		add r4,r4,r3
		ret2: ldr r3,[r7,#STCLO]
			cmp r3,r4
			blt ret2
			bx lr
			
wait3: 	ldr r7,=STBASE
		ldr r3,[r7,#STCLO]
		ldr r4,=25000
		add r4,r4,r3
		ret3: ldr r3,[r7,#STCLO]
			cmp r3,r4
			blt ret3
			bx lr

end: b end
