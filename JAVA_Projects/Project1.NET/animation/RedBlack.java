/*
    Author: Swapnil Kadam
*/


import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.*;
import java.lang.*;

/*
    THIS SECTION IMPLEMENTS ALL THE INTERFACE WHICH ARE USED 
 All storeable data items must implement the TreeObject interface
*/

interface TreeObject {
   int getValue ();
   String getIdent ();
}

class IntObject implements TreeObject {
   int x;
   IntObject (int x) { this.x = x; }
   public int getValue () { return x; }
   public String getIdent () { return String.valueOf(x); }
}

interface RBTree_inorder_class {
   boolean compare (TreeObject obj1, TreeObject obj2);//THIS METHOD IS TO FIND WHICH OBJECT IS SMALLER
}


// IT IMLEMENTS THE ABOVE INTERFACE
class IntInorderObject implements RBTree_inorder_class {
   public boolean compare (TreeObject obj1, TreeObject obj2) {
      return obj1.getValue() <= obj2.getValue();
   }
}

interface RBTree_compare_class {
   int evaluate (TreeObject object);
}

// An implementation of the above for the simple integers.
class IntCompare implements RBTree_compare_class {
   int x;
   IntCompare (int x) { this.x = x; }

   public int evaluate (TreeObject object) {
      if (x < object.getValue()) return -1;
      if (x > object.getValue()) return 1;
      return 0;
   }
}

class TO implements TokenObject { 
   public boolean value; 
   TO (boolean b) { value = b; }
}

// CLASSES TO IMPLENT THE BST ALGO
// Dot objects provide the DATA STRUCTURE for maintaining  data

class Dot {
   int   level, indent;
   float left, top;
   Dot   leftTree, rightTree, parent, sentinel;
   Color color, disp_color;
   TreeObject object;

   public Dot () { }

   public Dot (Dot sentinel) {  
      disp_color = color = Color.blue;  // FOR NEW NODE
      this.sentinel = sentinel; 
      level = 0;
      indent = 0;
   }

   public Dot (int n, Color clr) {
      color = disp_color = clr;
      object = new IntObject(n); //FOR ROOT
      leftTree = null;
      rightTree = null;
   }

   public Dot (RBTree tree, int n, Color clr) {
      sentinel = tree.sentinel;
      leftTree = sentinel;
      rightTree = sentinel;
      color = disp_color = clr;
      object = new IntObject(n);// TO BE IN TREE
      level = 0;
      indent = 0;
      parent = tree.rootSentinel;
      left = 0;
      top = 0;
   }

   // Finds the next lowest ordered stored object.  Returns null if
   // Used when deleting a node to find which node should take its place in the tree.

   public Dot getPrev() {
      Dot current = this;
      // IF IT IS NOT A LEAF FIND THE RIGHT MOST NODE IN THE TREE

      if (current.leftTree.leftTree != current.leftTree) {
         current = current.leftTree;
         while (current.rightTree.rightTree != current.rightTree)
            current = current.rightTree;
         return current;
      }
    else {
         Dot cur_parent = current.parent;
         while (cur_parent.leftTree == current) {
            current = cur_parent;
            cur_parent= cur_parent.parent;
            if (cur_parent == null) return null;
         }
         return cur_parent;
      }
   }

   // Finds the next highest stored object.  Returns null if none exists.

   public Dot getNext() {
      Dot current = this;
// IF WE ARE NOT AT THE LEAF FIND THE LEFT MOST NODE

      if (current.rightTree.rightTree != current.rightTree) {
         current = current.rightTree;
         while (current.leftTree.leftTree != current.leftTree)
            current = current.leftTree;
         return current;
      }
      else {
         Dot cur_parent = current.parent;
         while (cur_parent.rightTree == current) {
            current = cur_parent;
            cur_parent = current.parent;
         }
         if (cur_parent.parent == null) return null;
         return cur_parent;
      }
   }

   public void rightRotate( ) {
      if (this.parent.leftTree == this)
         leftSide_RightRotate( );
      else
         rightSide_RightRotate( );
   }

   public void leftRotate( ) {
      if (this.parent.leftTree == this)
         leftSide_LeftRotate( );
      else
         rightSide_LeftRotate( );
   }

   public void leftSide_LeftRotate() {
      Dot temp = this.parent; // temp is used for parent
      Dot child = this.rightTree;

      temp.leftTree = child;
      child.parent = temp;

      temp = child.leftTree; // temp is now used for grandchild
      this.rightTree = temp;
      temp.parent = this;
      
      child.leftTree = this;
      this.parent = child;
   }

   public void leftSide_RightRotate() {
      Dot temp = this.parent; // temp is used for parent
      Dot child = this.leftTree;

      temp.leftTree = child;
      child.parent = temp;

      temp = child.rightTree; // temp is now used for grandchild
      this.leftTree = temp;
      temp.parent = this;
      
      child.rightTree = this;
      this.parent = child;
   }

   public void rightSide_RightRotate( ) {
      Dot temp = this.parent; // temp is used for parent
      Dot child = this.leftTree;

      temp.rightTree = child;
      child.parent = temp;

      temp = child.rightTree; // temp is now used for grandchild
      this.leftTree = temp;
      temp.parent = this;

      child.rightTree = this;
      this.parent = child;
   }

   public void rightSide_LeftRotate( ) {
      Dot temp = this.parent; // temp is used for parent
      Dot child = this.rightTree;

      temp.rightTree = child;
      child.parent = temp;

      temp = child.leftTree; // temp is now used for grandchild
      this.rightTree= temp;
      temp.parent = this;

      child.leftTree = this;
      this.parent = child;
   }
}

// Used when adding a node to put the tree in balance

class Balance extends Stream {
   // current is the parent node of the node just added.  The child is red.
   Dot current;
   RBTree rbt;
   TO tot = new TO(true);

   public Balance (RBTree rbt, Dot dot) { 
      this.rbt = rbt;
      current = dot; 
   }

   public void run () {
      // if Current is a black node, no rotations needed
      while (current.color != Color.black) {
         // if (!Current->Parent) break;  XXX may not need this
         // Current is red, the imbalanced child is red, and parent is black.
         Dot cur_parent = current.parent;

         // If the current is on the right of the parent, the parent is 
         // to the left
         if (cur_parent.rightTree == current) {
            // if the sibling is also red, we can pull down the color 
            // black from the parent
            if (cur_parent.leftTree.color == Color.red) {
               cur_parent.leftTree.color = 
                  cur_parent.leftTree.disp_color = Color.black;
               current.color = current.disp_color = Color.black;
               cur_parent.color = cur_parent.disp_color = Color.red;
               rbt.level();
               putIt(tot);
               current = cur_parent.parent;
               continue;
            }
            if (current.leftTree.color == Color.red) {
               current.rightSide_RightRotate( );
               rbt.level();
               putIt(tot);
            }

            // Now we can do our left rotation to balance the tree.
            cur_parent.leftRotate();
            rbt.level();

            if (cur_parent.color == Color.red && 
                cur_parent.parent.color == Color.black) {
               putIt(null);
               return;
            } else {
               putIt(tot);
               cur_parent.color = cur_parent.disp_color = Color.red;
               cur_parent.parent.color = 
                  cur_parent.parent.disp_color = Color.black;
               rbt.level();
               putIt(null);
               return;
            }
         }
         // else the parent is to the right
         else {
            // if the sibling is also red, we can pull down the color black 
            // from the parent
            if (cur_parent.rightTree.color == Color.red) {
               cur_parent.rightTree.color = 
                  cur_parent.rightTree.disp_color = Color.black;
               current.color = current.disp_color = Color.black;
               cur_parent.color = cur_parent.disp_color = Color.red;
               rbt.level();
               putIt(tot);
               // jump twice up the tree. if Current reaches the rootSentinel 
               // (black node), the loop will stop
               current = cur_parent.parent;
               continue;
            }
            // if the imbalance (red node) is on the right, and the parent 
            // is on the right, a "prep-slide" is needed. (see diagram)
            if (current.rightTree.color == Color.red) {
               current.leftSide_LeftRotate( );
               rbt.level();
               putIt(tot);
            }
            
            // Now we can do our left rotation to balance the tree.
            cur_parent.rightRotate( );
            rbt.level();
            if (cur_parent.color == Color.red &&
                cur_parent.parent.color == Color.black) {
               putIt(null);
               return;
            } else {
               putIt(tot);
               cur_parent.color = cur_parent.disp_color = Color.red;
               cur_parent.parent.color = 
                  cur_parent.parent.disp_color = Color.black;
               rbt.level();
               putIt(null);
               return;
            }
         }
      }
      rbt.level();
      putIt(null);
      return;
   }
}

// For adding an object to the red-black tree.

class Add extends Stream {
   Dot newNode;
   RBTree_inorder_class inorder;
   Dot sentinel, rootSentinel;
   RBTree rbt;
   TO tot = new TO(true);
   TO tof = new TO(false);

   public Add (RBTree rbt, Dot newNode, RBTree_inorder_class inorder) {
      this.newNode = newNode;
      this.inorder = inorder;
      sentinel = rbt.sentinel;
      rootSentinel = rbt.rootSentinel;
      this.rbt = rbt;
   }

   public void run () {
      if (newNode.color != Color.blue) {
         putIt(null);
         return;
      }

      newNode.color = newNode.disp_color = Color.red;
      newNode.sentinel = sentinel;
      newNode.leftTree =  sentinel;
      newNode.rightTree = sentinel;

      Dot current = rootSentinel.leftTree;
      if (current == sentinel) {
         rootSentinel.leftTree = newNode;
         newNode.parent = rootSentinel;
      } else {
         do {
            // if the new node comes before the current node, go left
            if (inorder.compare( newNode.object, current.object )) {
               if (current.leftTree == sentinel) {
                  current.leftTree = newNode;
                  newNode.parent = current;
                  rbt.level();
                  putIt(tot);
                  break;
               }
               else current = current.leftTree;
            } else {  // go right
               if (current.rightTree == sentinel) {
                  current.rightTree = newNode;
                  newNode.parent = current;
                  rbt.level();
                  putIt(tot);
                  break;
               }
               else current = current.rightTree;
            }
         } while (true);
         TO bal;
         Balance balance = new Balance(rbt, current);
         while ((bal = (TO)balance.next()) != null) {
            rbt.level();
            putIt(bal);
         }
         balance = null;
      }
      rootSentinel.leftTree.color = 
         rootSentinel.leftTree.disp_color = Color.black;
      rbt.level();
      putIt(null);
      return;
   }
}

// For removing an object from a red-black tree.

class Prune extends Stream {
   RBTree rbt;
   Dot current;
   TO tot = new TO(true);

   public Prune (RBTree rbt, Dot dot) { current = dot; this.rbt = rbt; }

   public void run () {
      if (current.color == Color.blue) {
         putIt(null);
         return;
      }
      // If this is a leaf node (or almost a leaf) we can just prune it
      if (current.leftTree.leftTree == current.leftTree || 
          current.rightTree.rightTree == current.rightTree) {
         TO pru;
         PruneLeaf pruner = new PruneLeaf(rbt, current);
         while ((pru = (TO)pruner.next()) != null) {
            rbt.level();
            putIt(pru);
         }
         pruner = null;
      }
      // Otherwise we need a successor.  We are guaranteed to have one because
      // the current node has 2 children.
      else {
         Dot successor = current.getNext( );
         // Do we like this successor?  If not, get the other one.
         if (successor.color == Color.black && 
             successor.leftTree.leftTree == successor.leftTree && 
             successor.rightTree.rightTree == successor.rightTree)
            successor = current.getPrev( );
         successor.disp_color = Color.yellow; // JVF

         TO pru;
         PruneLeaf pruner = new PruneLeaf(rbt, successor);
         while ((pru = (TO)pruner.next()) != null) {
            rbt.level();
            putIt(pru);
         }
         pruner = null;

         // now exchange the successor for the current node
         Dot Temp = current.rightTree;
         successor.rightTree = Temp;
         Temp.parent = successor;
         
         Temp = current.leftTree;
         successor.leftTree = Temp;
         Temp.parent = successor;

         Temp = current.parent;
         successor.parent = Temp;
         if (Temp.leftTree == current) Temp.leftTree = successor; 
         else Temp.rightTree = successor;
         successor.color = successor.disp_color = current.color;

         rbt.level();
         putIt(tot);
      }
      current.color = current.disp_color = Color.blue;
      rbt.level();
      putIt(null);
      return;
   }
}

// PruneLeaf performs pruning of nodes with at most one child.

class PruneLeaf extends Stream {
   TO tot = new TO(true);
   Dot node;
   RBTree rbt;

   public PruneLeaf (RBTree rbt, Dot dot) { node = dot; this.rbt = rbt; }

   public void run () {
      Dot node_parent = node.parent;
      boolean leftSide = (node_parent.leftTree == node);

      // if the node is red and has at most one child, then it has no child.
      // So prune it.
      if (node.color == Color.red) {
         if (leftSide) node_parent.leftTree = rbt.sentinel;
         else node_parent.rightTree = rbt.sentinel;
         rbt.level();
         putIt(null);
         return;
      }

      // Node is black here.  If it has a child, the child will be red.
      if (node.leftTree != rbt.sentinel) {
         // swap with child
         node.leftTree.color = node.leftTree.disp_color = Color.black;
         node.leftTree.parent = node_parent;
         if (leftSide) node_parent.leftTree = node.leftTree;
         else node_parent.rightTree = node.leftTree;
         rbt.level();
         putIt(null);
         return;
      }
      if (node.rightTree != rbt.sentinel) {
         // swap with child
         node.rightTree.color = node.rightTree.disp_color = Color.black;
         node.rightTree.parent = node_parent;
         if (leftSide) node_parent.leftTree = node.rightTree;
         else node_parent.rightTree = node.rightTree;
         rbt.level();
         putIt(null);
         return;
      }

      if (leftSide) node_parent.leftTree = rbt.sentinel; 
      else node_parent.rightTree = rbt.sentinel;
      rbt.level();
      putIt(tot);

      Dot sibling = (leftSide) ? node_parent.rightTree : node_parent.leftTree;
      Dot current = node;
      
      while (current.color == Color.black && node_parent.parent != null) {
         if (sibling.color == Color.red) {
            node_parent.color = node_parent.disp_color = Color.red;
            sibling.color = sibling.disp_color = Color.black;
            rbt.level();
            putIt(tot);

            if (leftSide) {
               node_parent.leftRotate( );
               sibling = node_parent.rightTree;
            } else {
               node_parent.rightRotate( );
               sibling = node_parent.leftTree;
            }
            rbt.level();
            putIt(tot);

            continue;
         }
         if (sibling.rightTree.color == Color.black && 
             sibling.leftTree.color == Color.black) {
            if (sibling.color != Color.red) {
               sibling.color = sibling.disp_color = Color.red;
               rbt.level();
               putIt(tot);
            }

            // Now we move one level up the tree to continue fixing the
            // other branches.
            current = node_parent;
            node_parent = current.parent;
            leftSide = (node_parent.leftTree == current);
            sibling = (leftSide)? node_parent.rightTree : node_parent.leftTree;
            continue;
         }

         if (leftSide) {
            if (sibling.rightTree.color == Color.black) { // Case 3 from text
               sibling.rightSide_RightRotate( );
               sibling = node_parent.rightTree;
               rbt.level();
               putIt(tot);
            }
            // now Case 4 from the text
            if (sibling.rightTree.color != Color.black ||
                sibling.color != node_parent.color ||
                node_parent.color != Color.black) {
               sibling.rightTree.color = 
                  sibling.rightTree.disp_color = Color.black;
               sibling.color = sibling.disp_color = node_parent.color;
               node_parent.color = node_parent.disp_color = Color.black;
               rbt.level();
               putIt(tot);
            }

            current = node_parent;
            node_parent = current.parent;
            if (node_parent.leftTree == current)
               current.leftSide_LeftRotate( );
            else
               current.rightSide_LeftRotate( );
            rbt.level();
            putIt(null);
            return;
         } else {
            if (sibling.leftTree.color == Color.black) { // Case 3 from text
               sibling.leftSide_LeftRotate( );
               sibling = node_parent.leftTree;
               rbt.level();
               putIt(tot);
            }
            // Case 4 from the text
            if (sibling.leftTree.color != Color.black ||
                sibling.color != node_parent.color ||
                node_parent.color != Color.black) {
               sibling.leftTree.color = 
                  sibling.leftTree.disp_color = Color.black;
               sibling.color = sibling.disp_color = node_parent.color;
               node_parent.color = node_parent.disp_color = Color.black;
               rbt.level();
               putIt(tot);
            }
            current = node_parent;
            node_parent = current.parent;
            if (node_parent.leftTree == current)
               current.leftSide_RightRotate();
            else
               current.rightSide_RightRotate();
            rbt.level();
            putIt(null);
            return;
         }
      }

      current.color = current.disp_color = Color.black;
      rbt.level();
      putIt(null);
      return;
   }
}

class RBTree {
   Dot sentinel, rootSentinel;

   RBTree() {
      sentinel = new Dot(sentinel);
      sentinel.leftTree = sentinel;
      sentinel.rightTree = sentinel;
      sentinel.parent = sentinel;
      sentinel.color = sentinel.disp_color = Color.black;
      sentinel.object = null;
      rootSentinel = new Dot(sentinel);
      rootSentinel.color = rootSentinel.disp_color = Color.black;
      rootSentinel.leftTree = sentinel;
      rootSentinel.rightTree = sentinel;
      rootSentinel.parent = null; // uniquely marks this as the root sentinel
      rootSentinel.object = null;
   }

   RBTree(RBTree tree) {
      sentinel = new Dot(sentinel);
      sentinel.leftTree = sentinel;
      sentinel.rightTree = sentinel;
      sentinel.parent = sentinel;
      sentinel.color = sentinel.disp_color = Color.black;
      sentinel.object = null;
      rootSentinel = new Dot(sentinel);
      rootSentinel.color = rootSentinel.disp_color = Color.black;
      rootSentinel.leftTree = sentinel;
      rootSentinel.rightTree = sentinel;
      rootSentinel.parent = null; // uniquely marks this as the root sentinel
      rootSentinel.object = null;
      rootSentinel.leftTree = 
         copyTree(tree.rootSentinel.leftTree, rootSentinel);
   }

   Dot copyTree (Dot dot, Dot parent) {
      Dot leftTree, rightTree, newdot;
      if (dot == dot.sentinel) return sentinel;
      if (dot.object == null) return sentinel;
      newdot = new Dot();
      newdot.parent = parent;
      newdot.color = newdot.disp_color = dot.color;
      newdot.left = dot.left;
      newdot.top = dot.top;
      newdot.level = dot.level;
      newdot.indent = dot.indent;
      newdot.object = dot.object;
      if (dot.leftTree == dot.sentinel) newdot.leftTree = sentinel;
      else newdot.leftTree = copyTree(dot.leftTree, newdot);
      if (dot.rightTree == dot.sentinel) newdot.rightTree = sentinel;
      else newdot.rightTree = copyTree(dot.rightTree, newdot);
      return newdot;
   }

   int traverse (Dot tree, Dot dot[], int ndots, Dot dott[], int ndotts) {
      if (tree == sentinel || tree == rootSentinel) return ndotts;
      dott[ndotts] = tree;
      for (int i=0 ; i < ndots ; i++) {
         if (dot[i] == null || dot[i].object == null) continue;
         if (dot[i].object == tree.object) {
            dott[ndotts].left = dot[i].left;
            dott[ndotts].top = dot[i].top;
            break;
         }
      }
      int n = traverse(tree.leftTree, dot, ndots, dott, ndotts+1);
      return traverse(tree.rightTree, dot, ndots, dott, n);
   }

   int setDots (Dot dot[], int ndots, Dot dott[], int ndotts) {
      return traverse(rootSentinel.leftTree, dot, ndots, dott, ndotts);
   }

   void reLevel(Dot dot, int ind, int lvl) {
      if (dot == sentinel) return;
      dot.level = lvl;
      dot.indent = ind;
      reLevel(dot.leftTree,  2*ind,   lvl+1);
      reLevel(dot.rightTree, 2*ind+1, lvl+1);
   }

   public void level() {
      reLevel(rootSentinel, 0, -1);
   }
}

// Where all the drawing takes place
class DotPanel extends Panel implements Runnable {
   RedBlack graph;
   Thread relaxer;
   Dot pick, saved_pick, deletingNode;
   boolean deleteNode = false, removingNode = false;
   int delayer = 50;

   DotPanel(RedBlack graph) {  
      this.graph = graph;  
   }

   public void run() {
      while (true) {
         repaint();
         try { Thread.sleep(delayer); }
         catch (InterruptedException e) {  break;  }
      }
   }

   Image offscreen;
   Dimension offscreensize;
   Graphics offgraphics;

   int left (Dot dot) {
      Dimension d = getSize();
      double wid = (double)d.width/(1+(1 << dot.level));
      return (int)(wid*(dot.indent+1)) + 15;
   }

   int top(Dot dot) {  return 20+dot.level*50 + 15;  }

   int offset = 28;

   public void paintDot(Graphics g, Dot dot, FontMetrics fm, int ox, int oy) {
      if (dot == null) return;
     
      int x  = left(dot);
      int y  = top(dot);
      int tx = (int)dot.left;
      int ty = (int)dot.top;

      String lbl = String.valueOf(dot.object.getIdent());
      int w = fm.stringWidth(lbl);
      int h = fm.getHeight();
      g.setColor(dot.disp_color);
      g.fillOval(tx+ox-offset, ty+oy, 30, 30);
      g.setColor(Color.white);
      g.drawString(lbl, tx+ox-offset-w/2+15, ty+oy+12+h/2);
      dot.left = (float)(.9*(dot.left-x) + x);
      dot.top = (float)(.9*(dot.top-y) + y);
   }

   public void paintPickedDot(Graphics g, Dot dot, FontMetrics fm) {
      if (dot == null) return;
      
      int tx = (int)dot.left;
      int ty = (int)dot.top;

      String lbl = String.valueOf(dot.object.getIdent());
      int w = fm.stringWidth(lbl);
      int h = fm.getHeight();
      g.setColor(dot.disp_color);
      g.fillOval(tx-offset, ty, 30, 30);
      g.setColor(Color.white);
      g.drawString(lbl, tx-offset-w/2+15, ty+12+h/2);
   }

   public void paintEdgesOfDot(Graphics g, Dot dot) {
      if (dot == null || 
          dot == graph.tree.sentinel || 
          dot == graph.tree.rootSentinel) return;
      
      g.setColor(Color.black);
      int x = (int)dot.left+15;
      int y = (int)dot.top+15;
      if (dot.leftTree != null && dot.leftTree != graph.tree.sentinel) {
         int lx = (int)dot.leftTree.left+15;
         int ly = (int)dot.leftTree.top+15;
         g.drawLine(x-offset,y,lx-offset,ly);
      }
      if (dot.rightTree != null && dot.rightTree != graph.tree.sentinel) {
         int rx = (int)dot.rightTree.left+15;
         int ry = (int)dot.rightTree.top+15;
         g.drawLine(x-offset,y,rx-offset,ry);
      }
   }

   public void update(Graphics g) {
      Dimension d = getSize();
      if ((offscreen == null) || (d.width != offscreensize.width) ||
          (d.height != offscreensize.height)) {
         offscreen = createImage(d.width, d.height);
         offscreensize = d;
         offgraphics = offscreen.getGraphics();
         offgraphics.setFont(getFont());
      }

      offgraphics.setColor(graph.getColor());
      offgraphics.fillRect(0, 0, d.width, d.height);
      FontMetrics fm = offgraphics.getFontMetrics();
      Dot dt[] = graph.dot;
      int nd  = graph.ndots;
      for (int i=0 ; i < nd ; i++)
         paintEdgesOfDot(offgraphics, dt[i]);
      for (int i=0 ; i < nd ; i++)
         if (dt[i] != pick) paintDot(offgraphics, dt[i], fm, 0, 0);
         else paintPickedDot(offgraphics, dt[i], fm);
      if (graph.newest != null)
         paintDot(offgraphics, graph.newest, fm, -30, -15);
      g.drawImage(offscreen, 0, 0, null);
   }

   public boolean mouseDown (Event evt, int x, int y) {
      Dot dot[] = graph.dot;
      for (int i=0 ; i < graph.ndots ; i++) {
         if (dot[i] == null) continue;
         if (x-dot[i].left < 0 && y-dot[i].top < 30 &&
             x > dot[i].left-30 && y > dot[i].top) {
            saved_pick = pick = dot[i];
            if (deleteNode == true) {
               deleteNode = false;
               deletingNode = pick;
               deletingNode.disp_color = Color.green;
               removingNode = true;
            }
         }
      }
      return true;
   }

   public boolean mouseDrag (Event evt, int x, int y) {
      if (pick != null) {
         pick.left = x+20;
         pick.top = y-10;
      }
      return true;
   }

   public boolean mouseUp (Event evt, int x, int y) {
      pick = null;
      return true;
   }

   public void start() { relaxer = new Thread(this);  relaxer.start(); }
}

public class RedBlack extends Frame {
   public RedBlack()
      {
      super("Binary Search Tree :- Developed By:- Swapnil Kadam");
      init(); 
	}

   DotPanel panel;
   RBTree tree = null, saved_tree = null;
   Add adder = null;
   Prune pruner = null;
   Dot dot[] = new Dot[100], root = null, newest = null;
   int ndots = 0;
   Button addbutton, nextbutton, undobutton, colorit,
      restartbutton, tempbutton, delbutton,exitbutton;
   Choice speed;
   Color bgcolor = new Color(255,255,255);
   int number = 0;
   TextField value;
   Label label;

   public void init () {
      setBackground(bgcolor);
      setLayout(new BorderLayout());
      tree = new RBTree();
      panel = new DotPanel(this);
      panel.setBackground(bgcolor);
      add("Center", panel);
      Panel p = new Panel();
      p.setLayout(new GridLayout(2,1));
      Panel p1 = new Panel();
      p1.add(value = new TextField(5));
      p1.add(addbutton = new Button("Add Node"));
      p1.add(nextbutton = new Button("Next Step"));
      p1.add(delbutton = new Button("Delete Node"));
      p.add(p1);
      p1 = new Panel();
 //p1.add(restartbutton = new Button("Restart"));
      p1.add(label = new Label("            ", Label.CENTER));
     //p1.add(undobutton = new Button("Undo"));

//uncommet if dontwant AVL      
//p1.add(colorit = new Button("Color"));
    // p1.add(speed = new Choice());
     //speed.addItem("Fast");
     //speed.addItem("Slow");
     //speed.addItem("Crawl");
      p1.add(exitbutton = new Button("Exit"));

      p.add(p1);
      add("South", p);
      label.setBackground(bgcolor);
      value.setBackground(Color.white);
      initialize();
   }

   public void add_one (int number) {
      newest = new Dot(number, Color.blue);
      root = tree.rootSentinel.leftTree;
         
      while (true) {
         if (newest != null && adder == null) {
            if ((root = insertDot(newest, root)) == tree.sentinel) {
               dot[ndots++] = newest;
               adder = new Add(tree, newest, new IntInorderObject());
               TO to = (TO)adder.next();
               if (to == null) {
                  adder = null;
                  number = 0;
                  tree.level();
                  break;
               }
               tree.level();
               newest = root = null;
            } else if (root == null) { // Done adding a node
               newest = root = null;
               number = 0;
               tree.level();
               break;
            } // otherwise root is set to the next node down the tree
         } else if (adder != null) {  // Adding a node continuing...
            TO to = (TO)adder.next();
            if (to == null) {
               adder = null; 
               number = 0;
               tree.level();
               break;
            }
            tree.level();
         }
      }
}
public static void main(String args[])
	{
		RedBlack obj=new RedBlack();
		obj.addWindowListener(new WindowAdapter() 
						{
					public void windowClosing(WindowEvent e)
							{
		System.out.println(" Developed BY:-Swapnil");

									System.exit(0);
							}
						});				
		
		   obj.setSize(400,400);
		      obj.setVisible(true);
	

	}
	
          
   

   public void quick_add () {
      try {
         int number = Integer.parseInt(value.getText());
         saved_tree = new RBTree(tree);
	 // if tree is empty add a node by hand
	 if (tree.rootSentinel.leftTree == tree.sentinel) {
	    tree.rootSentinel.leftTree = new Dot(tree, number, Color.black);
	    dot = new Dot[100];
	    ndots = 0;
	    dot[ndots++] = tree.rootSentinel.leftTree;
	    tree.level();
	 } else {
	    add_one (number);
	 }
	 value.setText("");
	 number = 0;
      } catch (Exception e) {}
      value.setText("");
      number = 0;
   }

   public void initialize () {
      restart();
   }

/*  Function to color the Nodes */
   public void colorIt() {
      if (panel.saved_pick != null) {
         if (panel.saved_pick.color == Color.red) {
            panel.saved_pick.color = Color.black;
            panel.saved_pick.disp_color = Color.black;
         } else {
            panel.saved_pick.color = Color.red;
            panel.saved_pick.disp_color = Color.red;
         }
      }
   }
                                                                 
   public void delete () {
      if (newest == null && adder == null && 
          !panel.removingNode && !panel.deleteNode && tree != null) {
         saved_tree = new RBTree(tree);
         panel.deleteNode = true;
         label.setBackground(Color.green);
         label.setText("Deleting");
      }
   }

/*   public void undo () {
      if (saved_tree == null) return;
      tree = new RBTree(saved_tree);
      Dot dott[] = new Dot[100];
      ndots = tree.setDots(dot, ndots, dott, 0);
      dot = dott;
      tree.level();
      newest = root = null;
      adder = null;
      pruner = null;
      panel.deleteNode = panel.removingNode = false;
      panel.saved_pick = null;
      label.setBackground(bgcolor);
   }
*/
   public void restart () {
      saved_tree = null;
      tree = new RBTree();
      newest = root = null;
      adder = null;
      pruner = null;
      dot = new Dot[100];
      ndots = 0;
      panel.deleteNode = panel.removingNode = false;
      panel.saved_pick = null;
      label.setBackground(bgcolor);
      label.setText("            ");
      value.setText("");
     number = 0;
panel.start();
   }

   public void next () {
      if (newest != null && adder == null) {  // Adding a node starting...
         if ((root = insertDot(newest, root)) == tree.sentinel) {
            dot[ndots++] = newest;
            adder = new Add(tree, newest, new IntInorderObject());
            TO to = (TO)adder.next();
            if (to == null) {
               adder = null;
               label.setBackground(bgcolor);
               label.setText("            ");
               value.setText("");
               number = 0;
            }
            tree.level();
            newest = root = null;
         } else if (root == null) { // Done adding a node
            newest = root = null;
            label.setBackground(bgcolor);
            label.setText("            ");
            value.setText("");
            number = 0;
         } // otherwise root is set to the next node down the tree
      } else if (adder != null) {  // Adding a node continuing...
         TO to = (TO)adder.next();
         if (to == null) {
            adder = null; 
            label.setBackground(bgcolor);
            label.setText("            ");
            value.setText("");
            number = 0;
         }
         tree.level();
      } else if (panel.removingNode) {  // Removing a node
         if (pruner == null) {
            panel.saved_pick.disp_color = panel.saved_pick.color;
            deleteDot(panel.saved_pick);
            pruner = new Prune(tree, panel.saved_pick);
         }
         TO to = (TO)pruner.next();
         if (to == null) {
            pruner = null; 
            label.setBackground(bgcolor);
            label.setText("            ");
            value.setText("");
            number = 0;
            panel.removingNode = false;
         }
         tree.level();
      }
   }

   public void add () {
      if (newest == null && adder == null && 
          !panel.removingNode && !panel.deleteNode) {
         saved_tree = new RBTree(tree);
         try {
            number = Integer.parseInt(value.getText());


            newest = new Dot(number, Color.blue);
            root = tree.rootSentinel.leftTree;
            label.setBackground(Color.yellow);
            label.setText("Adding");
         } catch (Exception e) {
            value.setText("-=*=-");
         }
      }
   }

public void EXIT() {

		System.out.println(" Developed BY:-Swapnil");
	System.exit(0);	

}
 
   public boolean action (Event evt, Object obj) {
      if (evt.target.equals(delbutton)) delete();
      else if (evt.target.equals(nextbutton)) next();
      else if (evt.target.equals(addbutton)) add();
	else if (evt.target.equals(exitbutton)) EXIT();

      else if (evt.target.equals(value)) quick_add();
      /*else if (evt.target.equals(speed)) {
         if (speed.getSelectedItem().equals("Fast")) fast();
         else if (speed.getSelectedItem().equals("Slow")) slow();
         else if (speed.getSelectedItem().equals("Crawl")) crawl();
      }*/
      //uncoment if dont want AVL Tree
//else if (evt.target.equals(colorit)) colorIt();
      return super.action(evt, obj);
   }

   public void deleteDot(Dot d) {
      int m;
      for (int k=0 ; k < ndots ; k++) {
         if (dot[k] == null) continue;
         if (dot[k] == d) {
            dot[k] = null;
            break;
         }
      }
   }

   public Dot insertDot(Dot dot, Dot root) {
      if (root == null) return null;
      if (root == tree.sentinel) return tree.sentinel;
      
      /*  Uncomment to prevent duplicate data objects  */
       
      if (dot.object.getValue() == root.object.getValue()) {
         return null;
      } else  

      if (dot.object.getValue() <= root.object.getValue()) {
         dot.level = root.level+1;
         dot.indent = 2*root.indent;
         if (root.leftTree == null || root.leftTree == tree.sentinel) {
            return tree.sentinel;
         }
         return root.leftTree;
      } else {
         dot.level = root.level+1;
         dot.indent = 2*root.indent+1;
         if (root.rightTree == null || root.rightTree == tree.sentinel) {
            return tree.sentinel;
         }
         return root.rightTree;
      }
   }

   public void start() {  panel.start();  }

   public Color getColor() {  return bgcolor;  }
}

