using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Huffman
{
    class Node
    {
        private HuffmanTree _Data;
        private Node _Link;
        public Node(HuffmanTree newData)
        {
            Data = newData;
        }

        public HuffmanTree Data { set { _Data = value; } get { return _Data; } }
        public Node Link { set { _Link = value; } get { return _Link; } }
    }
}
