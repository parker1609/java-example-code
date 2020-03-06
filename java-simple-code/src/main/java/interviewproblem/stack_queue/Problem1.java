package interviewproblem.stack_queue;

/*
 * 한 개로 세 개: 배열 한 개로 스택 세 개를 어떠헥 구현할지 설명하라.
 */
public class Problem1 {
    /*
     * 1) 배열 고정 크기로 늘림(한 스택에 데이터가 몰려있어도 모든 스택 크기를 늘려주는 방식이라 공간 낭비가 심함)
     * 2) 스택 크기에 따른 배열 크기 할당(구현이 복잡함)
     */

    private class ThreeStack {
        private int[] array = new int[100];
        private int arraySize;
        private int stack1Size;
        private int stack2Size;
        private int stack3Size;

        public ThreeStack() {
            this.arraySize = 100;
            this.stack1Size = 0;
            this.stack2Size = 0;
            this.stack3Size = 0;
        }

        // stack 번호 1, 2, 3
        public void add(int stackNumber, int data) {
            int stackSize = selectStackSize(stackNumber - 1);
            int pushIndex = (stackNumber - 1) + 3 * stackSize;

            if (pushIndex > arraySize) {
                // array 크기 2배로 늘리기, 새로 만든 배열에 기존 배열 복사
            }

            array[pushIndex] = data;
        }

        public int pop(int stackNumber) {
            int stackSize = selectStackSize(stackNumber);

            return array[(stackNumber - 1) + 3 * (stackSize - 1)];
        }

        private int selectStackSize(int stackNumber) {
            if (stackNumber < 0 || stackNumber > 2) {
                throw new IllegalArgumentException();
            }

            if (stackNumber == 0) {
                return stack1Size;
            } else if (stackNumber == 1) {
                return stack2Size;
            } else {
                return stack3Size;
            }
        }
    }
}
