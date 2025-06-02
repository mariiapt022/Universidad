/* Basic skeleton for programs using interrupts */

.include "configuration.inc" 
.include "symbolic.inc"

/* Vector Table inicialization */
	mov r0,#0
	ADDEXC 0x18, regular_interrupt @only if used
	
/* Stack init for IRQ mode */	
	mov     r0, #0b11010010   
	msr     cpsr_c, r0
	mov     sp, #0x8000
/* Stack init for FIQ mode */	
	mov     r0, #0b11010001
	msr     cpsr_c, r0
	mov     sp, #0x4000
		mov r8,#0
/* Stack init for SVC mode	*/
	mov     r0, #0b11010011
	msr     cpsr_c, r0
	mov     sp, #0x8000000
	
/* Continue my program here */
	
	mov r7,#0
	mov r6,#0
	mov r5,#0
	
	@enable timer irq c1
	ldr r0,=INTBASE
	mov r1,#0b0010
	str r1,[r0,#INTENIRQ1]
	
	@enable timer irq c3
	mov r1,#0b1000
	str r1,[r0,#INTENIRQ1]
	
	@get time
	ldr r0,=STBASE
	ldr r1,[r0,#STCLO]
	
	@prepare c1
	ldr r2,=2000000  @2 seconds
	add r2,r1,r2
	str r2,[r0,#STC1]
	
	@prepare c3
	add r2,r1,#1136  @440Hz
	str r2,[r0,#STC3]
	
	mov r1,#0b01010011
	msr cpsr_c,r1
	
end: b end

/* Regular interrupt (only if used) */
regular_interrupt:
	push {r0,r1,r3}
	
	ldr r0,=STBASE
	ldr r2,[r0,#STCS]
	tst r2,#0b0010
	bne C1
	
	@move the membrane of speaker
	ldr r0,=GPBASE
	ldr r1,=0x10
	eors r5,r5,#1
	streq r1,[r0,#GPSET0]
	strne r1,[r0,#GPCLR0]
	
	@reset timer
	ldr r0,=STBASE
	mov r1,#0b1000
	str r1,[r0,#STCS]
	
	@prepare c3
	ldr r1,[r0,#STCLO]
	add r2,r1,#1136 
	str r2,[r0,#STC3]
	
	b end_ri

C1:
	ldr r0,=GPBASE
	cmp r6,#1
	beq led1
	cmp r6,#2
	beq led2
	cmp r6,#3
	beq led3
	cmp r6,#4
	beq led4
	cmp r6,#5
	beq led5
	
	ldr r1,=0x200
	b cont 

led1:
	ldr r1,=0x400
	b cont

led2:
	ldr r1,=0x800
	b cont

led3:
	ldr r1,=0x20000
	b cont

led4:
	ldr r1,=0x400000
	b cont
	
led5:
	ldr r1,=0x8000000
	b cont
	
cont: eors r7,r7,#1
	strne r1,[r0,#GPSET0]
	streq r1,[r0,#GPCLR0]
	addeq r6,r6,#1
	cmp r6,#6
	movge r6,#0
	
	ldr r0,=STBASE
	mov r1,#0b0010
	str r1,[r0,#STCS]
	
	ldr r1,[r0,#STCLO]
	ldr r2,=2000000
	add r2,r1,r2
	str r2,[r0,#STC1]
	
end_ri:
	pop {r0,r1,r3}
	subs  pc, lr, #4
	
	
	