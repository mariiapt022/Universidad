.include "configuration.inc"
.include "inter.inc"

@Programa que tras pulsar un boton encienda dos amarillas y si el otro boton se
@presiona, ambos se apagan

	ldr r0, =GPBASE
x:	
	ldr r1,=0x08400000		@dos amarillas
	ldr r2,[r0,#GPLEV0]		@read button (1 no pressed, 0 pressed)
	tst r2,#0b00100			@force z=1 or 0 (#0b00100 boton1)
	streq r1,[r0,#GPSET0]	@si esta presinado lo enciende
	ldr r3,[r0,#GPLEV0]		@read button (1 no pressed, 0 pressed)
	tst r3,#0b01000			@force z=1 or 0 (#0b01000 boton2)
	streq r1,[r0,#GPCLR0]	@si esta presinado lo enciende
	b x
	
end: b end


