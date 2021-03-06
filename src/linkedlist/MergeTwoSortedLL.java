package linkedlist;

import java.util.Scanner;

public class MergeTwoSortedLL {
	
	public static LinkedListNode<Integer> takeInput() {
		LinkedListNode<Integer> head = null, tail = null;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter the elements of the linked list separated by space or return: ");
		int data = scanner.nextInt();
		while (data != -1) {
			LinkedListNode<Integer> newNode = new LinkedListNode(data);
			if (head == null) {
				head = newNode;
				tail = newNode;
			} else {
				tail.next = newNode;
				tail = newNode;
			}
			data = scanner.nextInt();
		}
		return head;
	}
	
	public static LinkedListNode<Integer> mergeTwoList(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
		LinkedListNode<Integer> head = null, tail = null; 
		if (head1.data < head2.data) { 
			head = head1; 
			tail = head1; 
			head1 = head1.next; 
			} else { 
				head = head2; 
				tail = head2; 
				head2 = head2.next; 
			} 
		while (head1 != null && head2 != null) { 
			if (head1.data < head2.data) { 
				tail.next = head1; 
				tail = tail.next; 
				head1 = head1.next; 
			} else { 
				tail.next = head2; 
				tail = tail.next; 
				head2 = head2.next; 
			} 
		} 
		if (head1 != null) { 
			tail.next = head1; 
		} 
		if (head2 != null) { 
			tail.next = head2; 
		} 
		return head; 
	}
	
	public static void print(LinkedListNode<Integer> head) {
		LinkedListNode<Integer> temp = head;
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		} 
		System.out.println();
	}
	
	public static void main(String[] args) {
		/*
		 Given two linked lists sorted in increasing order. Merge them in such a way that the 
		 result list is also sorted (in increasing order). 
		 
		 Try solving with O(1) auxiliary space (in-place). You just need to return the head 
		 of new linked list, don't print the elements. 
		 
		 Input format : 
		 Line 1 : Linked list 1 elements of length n (separated by space and terminated by -1) 
		 Line 2 : Linked list 2 elements of length m (separated by space and terminated by -1) 
		 
		 Output format : 
		 Merged list elements (separated by space) 
		 
		 Constraints : 
		 1 <= n, m <= 10^4 
		 
		 Sample Input : 
		 2 5 8 12 -1 
		 3 6 9 -1 
		 
		 Sample Output : 
		 2 3 5 6 8 9 12	
		 */
		LinkedListNode<Integer> head1 = takeInput();
		LinkedListNode<Integer> head2 = takeInput();
		LinkedListNode<Integer> head = mergeTwoList(head1, head2);
		print(head);
	}

}
