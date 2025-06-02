/* Basic skeleton for programs using ports (without interruptions) */

.include "configuration.inc" 
.include "symbolic.inc"

/* Stack init for SVC mode	*/
	mov     r0, #0b11010011
	msr     cpsr_c, r0
	mov     sp, #0x8000000
	
/* Continue my program here */

@Bucle que hace la nota LA (440Hz) durante 1s y la apaga 0,25s

	ldr r0, =GPBASE				
	ldr r1,=0x010				@sonido
		
loop: 	str r1,[r0,#GPSET0]		@suena
		BL wait					 
		str r1,[r0,#GPCLR0]		@se apaga
		BL wait
		B loop

wait: 	ldr r7,=STBASE			@r7=0x3F003004 (address of counter CLO)
		ldr r3,[r7,#STCLO]		@read the value of the counter
		ldr r4,=2272			@LA
		add r4,r4,r3			@adding to the current count to get the final count
		ret: ldr r3,[r7,#STCLO]	@read the current count
			cmp r3,r4			@comparing current count with the final count
			blt ret
			bx lr



end: b end


