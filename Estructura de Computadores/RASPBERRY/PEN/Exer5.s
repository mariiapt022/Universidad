/* Basic skeleton for programs using ports (without interruptions) */

.include "configuration.inc" 
.include "symbolic.inc"

/* Stack init for SVC mode	*/
	mov     r0, #0b11010011
	msr     cpsr_c, r0
	mov     sp, #0x8000000
	
/* Continue my program here */

@Programa que enciende las dos rojas, comprueba el estado de los botones
@y enciende la led del boton presionado mientras que del otro lo apaga

	ldr r0, =GPBASE
	ldr r1,=0x600			@las dos rojas
	str r1,[r0,#GPSET0]		@las enciende
	
x:
	ldr r1,=0x200			@una roja
	ldr r3,=0x400			@segunda roja
	
	ldr r2,[r0,#GPLEV0]		@read button (1 no pressed, 0 pressed)
	tst r2,#0b00100			@force z=1 or 0 (#0b00100 boton1)
	streq r1,[r0,#GPCLR0]	@si esta presionado se apaga
	
	ldr r4,[r0,#GPLEV0]		@read button (1 no pressed, 0 pressed)
	tst r4,#0b01000			@force z=1 or 0 (#0b01000 boton2)
	streq r3,[r0,#GPCLR0]	@si esta presionado se apaga
	b x

end: b end


