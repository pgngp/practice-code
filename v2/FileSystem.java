/* https://leetcode.com/problems/design-in-memory-file-system/submissions/ */
class FileSystem {
    private FSNode root;

    // constructor
    public FileSystem() {
        root = new FSNode("/", false);
    }
    
    // list file/dir
    public List<String> ls(String path) {
        // if path is "/"
        List<String> result = new ArrayList<>();
        if (path == "/") {
            for (Map.Entry<String, FSNode> entry : root.children.entrySet()) {
                result.add(entry.getKey());
            }
            
            return result;
        }
        
        // get the fsnode corresponding to the last file/dir in the path
        String[] items = path.split("/");
        FSNode node = root;
        for (String item : items) {
            if (item.isEmpty()) {
                continue;
            }
            node = node.children.get(item);
        }
        
        // if this is file
        if (node.isFile) {
            result.add(node.name);
            return result;
        }
        
        // this is dir
        for (Map.Entry<String, FSNode> entry : node.children.entrySet()) {
            result.add(entry.getKey());
        }
        
        return result;
    }
    
    // make dir
    public void mkdir(String path) {
        FSNode node = root;
        String[] items = path.split("/");
        for (String item : items) {
            if (item.isEmpty()) {
                continue;
            }
            
            if (!node.children.containsKey(item)) {
                FSNode newNode = new FSNode(item, false);
                node.children.put(item, newNode);
                node = newNode;
            } else {
                node = node.children.get(item);
            }
        }
    }
    
    // add content to file
    public void addContentToFile(String filePath, String content) {
        // parse to the second-last node
        FSNode node = root;
        String[] items = filePath.split("/");
        for (int i = 0; i < items.length - 1; i++) {
            if (items[i].isEmpty()) {
                continue;
            }
            node = node.children.get(items[i]);
        }
        
        // if last node already exists, append content
        if (node.children.containsKey(items[items.length - 1])) {
            node = node.children.get(items[items.length - 1]);
            node.content += content;
            return;
        }
        
        // create last node and add content
        FSNode newNode = new FSNode(items[items.length - 1], true);
        newNode.content = content;
        node.children.put(items[items.length - 1], newNode);
    }
    
    // read content from file
    public String readContentFromFile(String filePath) {
        FSNode node = root;
        String[] items = filePath.split("/");
        for (String item : items) {
            if (item.isEmpty()) {
                continue;
            }
            node = node.children.get(item);
        }
        
        return node.content;
    }
    
    public class FSNode {
        private String name;
        private Map<String, FSNode> children;
        private boolean isFile;
        private String content;
        
        public FSNode(String name, boolean isFile) {
            this.name = name;
            this.children = new TreeMap<>();
            this.isFile = isFile;
            this.content = "";
        }
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
