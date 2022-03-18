package LeetCodeDaily;

/*
思路：额外用了一个数组保存各个栈的真实size，方便操作；改成多个栈也就把3改一下。
*/
class TripleInOne {
    private int[] stack;
    private int stackSize;
    private int[] actual_size;

    public TripleInOne(int stackSize) {
        stack = new int[stackSize * 3];
        this.stackSize = stackSize;
        actual_size = new int[3];
    }

    public void push(int stackNum, int value) {
        if (actual_size[stackNum] != stackSize) {
            stack[stackNum * stackSize + actual_size[stackNum]++] = value;
        }
    }

    public int pop(int stackNum) {
        return isEmpty(stackNum) ? -1 : stack[stackNum * stackSize + --actual_size[stackNum]];
    }

    public int peek(int stackNum) {
        return isEmpty(stackNum) ? -1 : stack[stackNum * stackSize + actual_size[stackNum] - 1];
    }

    public boolean isEmpty(int stackNum) {
        return actual_size[stackNum] == 0;
    }
}
