using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp
{
    class PriorityQueue<T>
    {
        internal class Node : IComparable<Node>
        {
            public int Priority;
            public T O;
            public int CompareTo(Node other)
            {
                return Priority.CompareTo(other.Priority);
            }
        }

        private MinHeap<Node> minHeap = new MinHeap<Node>();

        public void Add(int priority, T element)
        {
            minHeap.Add(new Node() { Priority = priority, O = element });
        }

        public T RemoveMin()
        {
            return minHeap.RemoveMin().O;
        }

        public T Peek()
        {
            return minHeap.Peek().O;
        }

        public int Count
        {
            get
            {
                return minHeap.Count;
            }
        }
    }
}
