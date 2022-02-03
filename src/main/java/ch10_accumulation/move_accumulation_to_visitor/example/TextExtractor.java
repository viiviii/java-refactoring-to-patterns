package ch10_accumulation.move_accumulation_to_visitor.example;

public class TextExtractor {
    private final Parser parser;

    public TextExtractor(Parser parser) {
        this.parser = parser;
    }

    public String extractText() throws ParserException {
        Node node;
        boolean isPreTag = false;
        boolean isScriptTag = false;
        StringBuffer results = new StringBuffer();

        parser.flushScanners();
        parser.registerScanners();

        for (NodeIterator e = parser.elements(); e.hasMoreNodes(); ) {
            node = e.nextNode();
            if (node instanceof StringNode) {
                if (!isScriptTag) {
                    StringNode stringNode = (StringNode) node;
                    if (isPreTag) {
                        results.append(stringNode.getText());
                    } else {
                        String text = Translate.decode(stringNode.getText());
                        if (getReplaceNonBreakingSpace()) {
                            text = text.replace('\u00a0', ' ');
                        }
                        if (getCollapse()) {
                            collapse(results, text);
                        } else {
                            results.append(text);
                        }
                    }
                }
            } else if (node instanceof LinkTag) {
                LinkTag link = (LinkTag) node;
                if (isPreTag) {
                    results.append(link.getLinkText());
                } else {
                    collapse(results, Translate.decode(link.getLinkText()));
                    if (getLinks()) {
                        results.append("<");
                        results.append(link.getLink());
                        results.append(">");
                    }
                }
            } else if (node instanceof EndTag) {
                EndTag endTag = (EndTag) node;
                String tagName = endTag.getTagName();
                if (tagName.equalsIgnoreCase("PRE")) {
                    isPreTag = false;
                } else if (tagName.equalsIgnoreCase("SCRIPT")) {
                    isScriptTag = false;
                }

            } else if (node instanceof Tag) {
                Tag tag = (Tag) node;
                String tagName = tag.getTagName();
                if (tagName.equalsIgnoreCase("PRE")) {
                    isPreTag = true;
                } else if (tagName.equalsIgnoreCase("SCRIPT")) {
                    isScriptTag = true;
                }
            }
        }
        return (results.toString());
    }

    private boolean getReplaceNonBreakingSpace() {
        return false;
    }

    private boolean getCollapse() {
        return false;
    }

    private boolean getLinks() {
        return false;
    }

    private void collapse(StringBuffer results, String text) {
    }
}
