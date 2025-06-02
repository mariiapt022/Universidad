.include "configuration.inc"
.include "inter.inc"

@Programa que enciende una led amarilla mientras se presione uno de los 
@dos botones

	ldr r0, =GPBASE
x:	
	ldr r1,=0x800			@amarillo
	ldr r2,[r0,#GPLEV0]		@read button (1 no pressed, 0 pressed)
	tst r2,#0b00100			@force z=1 or 0 
	streq r1,[r0,#GPSET0]	@si esta presionado se enciende
	strne r1,[r0,#GPCLR0]	@si no se apaga
	b x

end: b end
	
	