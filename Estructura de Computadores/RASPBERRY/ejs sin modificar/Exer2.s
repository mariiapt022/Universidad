.include "configuration.inc"
.include "inter.inc"
	
	ldr r0, =GPBASE
x:	
	ldr r1,=0x800
	ldr r2,[r0,#GPLEV0]
	tst r2,#0b00100
	streq r1,[r0,#GPSET0]
	strne r1,[r0,#GPCLR0]
	b x

end: b end
	
	