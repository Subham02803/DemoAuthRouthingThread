import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Test1 {
	
	static class Tree{
		String s;
		List<Tree> children;
		public Tree(String s) {
			super();
			this.s = s;
			children = new ArrayList<Tree>();
		}
		public Tree() {
			super();
		}
	}

	public static Tree func(Map<String, String> map) {
		Tree t = new Tree("root");
		Map<String, Tree> nodes = new HashMap<String, Test1.Tree>();
		nodes.put("root", t);
		for(Entry<String, String> entry : map.entrySet()) {
			if(entry.getKey() == "root")
				continue;
			Tree parentNode = nodes.get(entry.getValue());
			Tree p = new Tree(entry.getKey());
			parentNode.children.add(p);
			nodes.put(entry.getKey(), p);
		}
		return t;
	}
	
	public static void main(String[] args) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("root", null);
		map.put("A", "root");
		map.put("B", "root");
		map.put("C", "A");
		map.put("D", "B");
		map.put("E", "C");
		map.put("F", "C");
		
		Tree tree = func(map);
		print(tree, 0);
	}
	
	static void print(Tree t, int tabs) {
		for(int i=1;i<tabs;i++)
			System.out.print("   ");
		if(!t.s.equals("root"))
			System.out.print("|__");
		System.out.print(t.s);
		System.out.println();
		if(!t.children.isEmpty()) {
			for(Tree i : t.children) {
				print(i,tabs+1);
			}
		}
	}
    

}
