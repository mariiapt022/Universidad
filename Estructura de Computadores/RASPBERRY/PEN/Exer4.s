/* Basic skeleton for programs using ports (without interruptions) */

.include "configuration.inc" 
.include "symbolic.inc"

/* Stack init for SVC mode	*/
	mov     r0, #0b11010011
	msr     cpsr_c, r0
	mov     sp, #0x8000000
	
/* Continue my program here */

@Programa que tras presionar el boton1 enciende una amarilla y tras presionar 
@boton2 enciende el verde

	ldr r0, =GPBASE
x:
	ldr r1,=0x800			@amarilla	
	ldr r4,=0xE000000		@verde
	
	ldr r2,[r0,#GPLEV0]		@read button (1 no pressed, 0 pressed)
	tst r2,#0b00100			@force z=1 or 0 (#0b00100 boton1)
	streq r1,[r0,#GPSET0]	@si esta presionado se enciende
	
	ldr r3,[r0,#GPLEV0]		@read button (1 no pressed, 0 pressed)
	tst r3,#0b01000			@force z=1 or 0 (#0b01000 boton2)
	streq r4,[r0,#GPSET0]	@si esta presionado se enciende
	b x

end: b end


