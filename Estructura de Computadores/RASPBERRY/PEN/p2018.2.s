/* Basic skeleton for programs using interrupts */

.include "configuration.inc" 
.include "symbolic.inc"

/* Vector Table inicialization */
	mov r0,#0
	ADDEXC 0x18, regular_interrupt @only if used
	ADDEXC 0x1C, fast_interrupt      @only if used


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

		ldr r5,=1000000
		ldr r6,=0
		ldr r7,=0
		
		@STC1
		ldr r0,=GPBASE
		ldr r1,[r0,#STCLO]
		add r1,r1,#1000000
		str r1,[r0,#STC1]
		
		@STC3
		ldr r0,=STBASE
		ldr r1,[r0,#STCLO]
		add r1,r1,#500
		str r1,[r0,#STC3]
		
		@Enable C1 IRQ
		ldr r0,=INTBASE
		mov r1,#0b1010
		str r1,[r0,#INTENIRQ1]
		
		@Enable C3 FIQ
		ldr r0,=INTBASE
		ldr r1,=0x083
		str r1,[r0,#INTFIQCON]
		
		@IRQ and FIQ
		mov r1,#0b00010011
		msr cpsr_c, r1 

end:   b end

/* Regular interrupt (only if used) */
regular_interrupt: 
	push {r0,r1,r2}
		push {LR}
			ldr r0,=STBASE
			ldr r2,[r0,#STCS]
			tst r2,#0b0010
			blne waiting
		pop {LR}
	pop {r0,r1,r2}
	subs  pc, lr, #4

waiting: push{r0-r4}
			push{LR}
				add r7,#1
				
				cmp r7,#0
				moveq r5,#1000000
				
				cmp r7,#1
				addeq r5,#1000000
				
				cmp r7,#2
				addeq r5,#1000000
				moveq r7,#0
				
				@STC1
				ldr r0,=STBASE
				mov r1,#0b0010
				str r1,[r0,#STCS]
				
				ldr r0,=STBASE
				ldr r1,[r0,#STCLO]
				add r1,r1,r5
				str r1,[r0,#STC1]
				
			pop{LR}
		push{r0-r4}
		bx lr	

/* Fast interrupt (only if used) */
fast_interrupt: 
	push {r0,r1,r2}
		push {LR}
			ldr r0,=STBASE
			ldr r2,[r0,#STCS]
			tst r2,#0b1000
			blne speaker
		pop {LR}

	pop {r0,r1,r2}
	subs  pc, lr, #4

speaker: push {r0-r5}
			ldr r0,=GPBASE
			eors r6,#1
			streq r1,[r0,#GPSET0]
			strne r1,[r0,#GPCLR0]
			
			@STC3
			ldr r0,=STBASE
			mov r1,#0b1000
			str r1,[r0,#STCS]
			
			cmp r7,#0
			moveq r4,#100
			
			cmp r7,#1
			moveq r4,#200
			
			cmp r7,#2
			moveq r4,#1000
			
			ldr r0,=GPBASE
			ldr r1,[r0,#STCLO]
			add r1,r1,r4 
			str r1,[r0,#STC3]
			
			pop {r0-r5}
			bx lr