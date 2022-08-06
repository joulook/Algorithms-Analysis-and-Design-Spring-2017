using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Huffman
{
    class TreeList
    {
        private int _Count = 0;

        public int Count { get { return _Count; } set { _Count = value; } }
        Node first;
        public void AddLetter(string letter)
        {
            HuffmanTree hTemp = new HuffmanTree(letter);
            Node eTemp = new Node(hTemp);
            if (first == null)
                first = eTemp;
            else   // اضافه به وسط لیست
            {
                eTemp.Link = first;
                first = eTemp;
            }
            Count++;
        }

        public void SortTree()
        {
            TreeList otherList = new TreeList();
            HuffmanTree aTemp;
            while (!(first == null))
            {
                aTemp = RemoveTree();
                otherList.InsertTree(aTemp);
            }
            first = otherList.first;
        }
        public void MergeTree()
        {
            if (!(first == null) && !(first.Link == null))
            {
                HuffmanTree aTemp = RemoveTree();
                HuffmanTree bTemp = RemoveTree();
                HuffmanTree sumTemp = new HuffmanTree();
                // همون قسمت ابتکاری برای یکتا شدن کدگذاری

                //var asciiInput1 = Encoding.ASCII.GetBytes(aTemp.Letter);
                //var asciiInput2 = Encoding.ASCII.GetBytes(bTemp.Letter);
                //int a=0, b=0;
                //foreach (var item in asciiInput1)
                //{
                //    a += item;
                //}
                //foreach (var item in asciiInput2)
                //{
                //    b += item;
                //}

                //if (a > b)
                //{
                //    HuffmanTree temp;
                //    temp = bTemp;
                //    bTemp = aTemp;
                //    aTemp = temp;
                //}

                if (String.Compare(aTemp.Letter,bTemp.Letter,StringComparison.Ordinal)<0)
                {
                    HuffmanTree temp;
                    temp = bTemp;
                    bTemp = aTemp;
                    aTemp = temp;
                }

                sumTemp.LeftChild = aTemp;
                sumTemp.RightChild = bTemp;

                sumTemp.Freq = aTemp.Freq + bTemp.Freq;
                InsertTree(sumTemp);
            }
        }

        public HuffmanTree RemoveTree() // حذف از اول لیست
        {
            if (!(first == null))
            {
                HuffmanTree hTemp;
                hTemp = first.Data;
                first = first.Link;
                Count--;
                return hTemp;
            }
            return null;
        }
        public void InsertTree(HuffmanTree hTemp)
        {
            Node eTemp = new Node(hTemp);
            if (first == null)
                first = eTemp;
            else
            {
                Node p = first;
                while (!(p.Link == null))
                {
                    if ((p.Data.Freq <= hTemp.Freq) && (p.Link.Data.Freq >= hTemp.Freq))
                        break;
                    p = p.Link;
                }
                eTemp.Link = p.Link;
                p.Link = eTemp;
            }
            Count++;
        }
        
    }
}