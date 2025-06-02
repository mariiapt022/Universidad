/* Basic skeleton for programs using ports (without interruptions) */

.include "configuration.inc" 
.include "symbolic.inc"

/* Stack init for SVC mode	*/
	mov     r0, #0b11010011
	msr     cpsr_c, r0
	mov     sp, #0x8000000
	
/* Continue my program here */

@Bucle que enciende las leds durante 1s y las apaga 0,25s

	ldr r0, =GPBASE
	ldr r1,=0xE000D00			@roja,amarilla,verde uno de cada
		
loop: 	str r1,[r0,#GPSET0]		@la enciende
		BL wait1				@entra en el bucle wait de 1s
		str r1,[r0,#GPCLR0]		@la apaga
		BL wait2				@entra en el bucle wait de 0,25s
		B loop					@vuelve a empezar

wait1: 	ldr r7,=STBASE			@r7=0x3F003004 (address of counter CLO)
		ldr r3,[r7,#STCLO]		@read the value of the counter
		ldr r4,=1000000			@r4=1000000 mu s
		add r4,r4,r3			@adding to the current count to get the final count
		ret1: ldr r3,[r7,#STCLO]@read the current count
			cmp r3,r4			@comparing current count with the final count
			blt ret1
			bx lr


wait2: 	ldr r7,=STBASE			@r7=0x3F003004 (address of counter CLO)
		ldr r3,[r7,#STCLO]		@read the value of the counter
		ldr r4,=25000			@r4=25000 mu s
		add r4,r4,r3			@adding to the current count to get the final count
		ret2: ldr r3,[r7,#STCLO]@read the current count
			cmp r3,r4			@comparing current count with the final count
			blt ret2
			bx lr


end: b end


