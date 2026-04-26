package org.talend.designer.codegen.translators.processing.fields;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.utils.NodeUtil;
import java.util.Map;
import java.util.List;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

public class TExtractJSONFieldsBeginJava
{
  protected static String nl;
  public static synchronized TExtractJSONFieldsBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TExtractJSONFieldsBeginJava result = new TExtractJSONFieldsBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "int nb_line_";
  protected final String TEXT_2 = " = 0;" + NL + "String jsonStr_";
  protected final String TEXT_3 = " = \"\";" + NL;
  protected final String TEXT_4 = NL + "\t";
  protected final String TEXT_5 = NL + NL + "class ConvertJSONString_";
  protected final String TEXT_6 = "{" + NL + "    final static int Brace = 0 ; // {" + NL + "    final static int Bracket = 1; // [" + NL + "    private int barceType = -1 ;" + NL + "    private String originalJsonString = \"\" ;" + NL + "    private String originalLoopString = \"\" ;" + NL + "    private String jsonString4XML = null;" + NL + "    private String loopString4XML = null;" + NL + "    private String additionRoot = null;" + NL + "    " + NL + "    public void barceType(){" + NL + "" + NL + "        for (int c = 0; c < originalJsonString.length(); ++c) {" + NL + "            if (originalJsonString.charAt(c) == '{') {" + NL + "                barceType = Brace;" + NL + "                break;" + NL + "            } else if (originalJsonString.charAt(c) == '[') {" + NL + "                barceType = Bracket;" + NL + "                break;" + NL + "            }" + NL + "        }" + NL + "    }" + NL + "" + NL + "    public void setJsonString (String originalJsonString) {" + NL + "        this.originalJsonString = originalJsonString;" + NL + "    }" + NL + "    " + NL + "    public void setLoopString (String originalLoopString) {" + NL + "        this.originalLoopString = originalLoopString;" + NL + "    }" + NL + "    " + NL + "    public String getJsonString4XML(){" + NL + "        return jsonString4XML;" + NL + "    }" + NL + "    " + NL + "    public String getLoopString4XML(){" + NL + "        if(loopString4XML.length()>1 && loopString4XML.endsWith(\"/\")){" + NL + "        \tloopString4XML = loopString4XML.substring(0, loopString4XML.length()-1);" + NL + "\t\t}" + NL + "        return loopString4XML;" + NL + "    }" + NL + "    " + NL + "    public void setAdditionRoot(String additionRoot) {" + NL + "        this.additionRoot = additionRoot;" + NL + "    }" + NL + "    " + NL + "    public String getAdditionRoot(){" + NL + "        return additionRoot;" + NL + "    }" + NL + "    " + NL + "    public void generate() {" + NL + "        barceType();" + NL + "        jsonString4XML = originalJsonString;" + NL + "        loopString4XML = originalLoopString;" + NL + "        if (Brace == barceType) {" + NL + "            if (isNeedAddRoot(originalJsonString)) {" + NL + "                jsonString4XML = \"{ \\\"root\\\": \" + originalJsonString + \" }\";" + NL + "                loopString4XML = \"root\" + originalLoopString;" + NL + "                setAdditionRoot(\"root\");" + NL + "            }" + NL + "        } else if (Bracket == barceType) {" + NL + "            jsonString4XML = \"{ \\\"root\\\" : { \\\"object\\\": \"" + NL + "                    + originalJsonString + \" } }\";" + NL + "            loopString4XML = \"root/object\" + originalLoopString;" + NL + "                setAdditionRoot(\"object\");" + NL + "        }" + NL + "    }" + NL + "" + NL + "    public boolean isNeedAddRoot(String originalJsonString) {" + NL + "        boolean isNeedAddRoot = false;" + NL + "        net.sf.json.JSONObject jso = net.sf.json.JSONObject" + NL + "                .fromObject(originalJsonString);" + NL + "        String jsonKey = \"\";" + NL + "        Object firstObject = null;" + NL + "        if (jso.names().size() == 1) {" + NL + "            jsonKey = jso.names().get(0).toString();" + NL + "            firstObject = jso.get(jsonKey);" + NL + "        }" + NL + "        if (jso.size() > 1" + NL + "                || (firstObject != null" + NL + "                        && firstObject instanceof net.sf.json.JSONArray && ((net.sf.json.JSONArray) firstObject)" + NL + "                        .size() > 1)) {" + NL + "            isNeedAddRoot = true;" + NL + "        }" + NL + "        return isNeedAddRoot;" + NL + "    }" + NL + "" + NL + "}" + NL + "" + NL + "ConvertJSONString_";
  protected final String TEXT_7 = " cjs_";
  protected final String TEXT_8 = " = new ConvertJSONString_";
  protected final String TEXT_9 = "();" + NL + "" + NL + "de.odysseus.staxon.json.JsonXMLConfig config_";
  protected final String TEXT_10 = " = new de.odysseus.staxon.json.JsonXMLConfigBuilder().multiplePI(false).build();" + NL + "de.odysseus.staxon.json.JsonXMLInputFactory jsonXMLInputFactory_";
  protected final String TEXT_11 = " = new de.odysseus.staxon.json.JsonXMLInputFactory(config_";
  protected final String TEXT_12 = ");" + NL + "javax.xml.stream.XMLOutputFactory xmlOutputFactory_";
  protected final String TEXT_13 = " = javax.xml.stream.XMLOutputFactory.newInstance();" + NL + "boolean isGetWholeJson_";
  protected final String TEXT_14 = " = false;" + NL + "" + NL + "\tclass OriginalJSONString_";
  protected final String TEXT_15 = " {";
  protected final String TEXT_16 = NL + NL + "        \t\tString originalJSONString = null;" + NL + "        \t\tjava.io.ByteArrayInputStream bais = null;" + NL + "        \t\tjava.io.ByteArrayOutputStream baos = null;" + NL + "        \t\tde.odysseus.staxon.json.JsonXMLConfig config = null;" + NL + "        \t\tde.odysseus.staxon.json.JsonXMLOutputFactory jxof = null;" + NL + "           \t\t" + NL + "           \t\tpublic String getOriginalJSONString(String xmlString,String additionRoot,String encoding,boolean isGetWholeJson, boolean isArray) throws Exception {" + NL + "" + NL + "    \t\t\t\t\ttry {" + NL + "\t           \t\t\t\tif(isArray){" + NL + "    \t       \t\t\t\t\txmlString = \"<list>\" + xmlString + \"</list>\";" + NL + "        \t   \t\t\t\t}" + NL + "    \t\t\t\t\t\tbais = new ByteArrayInputStream(xmlString.getBytes(encoding));" + NL + "                \t\t\tbaos = new java.io.ByteArrayOutputStream();" + NL + "                \t\t\tconfig = new de.odysseus.staxon.json.JsonXMLConfigBuilder().multiplePI(false).autoArray(true).build();" + NL + "                \t\t\tjxof = new de.odysseus.staxon.json.JsonXMLOutputFactory(config);" + NL + "            \t\t\t\tjavax.xml.stream.XMLEventReader xmlEventReader = javax.xml.stream.XMLInputFactory.newInstance().createXMLEventReader(bais,encoding);" + NL + "                \t\t\tjavax.xml.stream.XMLEventWriter xmLEventWriter = jxof.createXMLEventWriter(baos);" + NL + "    \t\t\t\t\t\txmLEventWriter.add(xmlEventReader);" + NL + "    \t\t\t\t\t\txmlEventReader.close();" + NL + "    \t\t\t\t\t\txmLEventWriter.close();" + NL + "    \t\t\t\t\t\tnet.sf.json.JSONObject json = net.sf.json.JSONObject.fromObject(baos.toString());" + NL + "\t\t\t\t\t\t\tif(isArray){" + NL + "\t\t\t\t\t\t\t\tjson = json.getJSONObject(\"list\");" + NL + "\t\t\t\t\t\t\t}" + NL + "    \t\t\t\t\t\tnet.sf.json.JSONObject originalJsonObject = null;" + NL + "\t\t\t\t\t\t\tif (!json.isNullObject()) {" + NL + "\t\t\t\t\t\t\t\tif (additionRoot == null) {" + NL + "\t\t\t\t\t\t\t\t\toriginalJSONString = json.toString();" + NL + "\t\t\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\t\t\tif (isGetWholeJson) {" + NL + "                                        originalJsonObject = json.getJSONObject(additionRoot);" + NL + "                                        if (!originalJsonObject.isNullObject()) {" + NL + "                                            originalJSONString = originalJsonObject.toString();" + NL + "                                        } " + NL + "                                    }else {" + NL + "                                            originalJSONString = json.toString();" + NL + "                                    }" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t}" + NL + "    \t\t\t\t\t} finally {" + NL + "    \t\t\t\t        baos.close();" + NL + "    \t\t\t\t        if(bais!=null){" + NL + "    \t\t\t\t            bais.close();" + NL + "    \t\t\t\t        }" + NL + "    \t\t\t\t\t}" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\treturn originalJSONString;" + NL + "\t\t\t\t}" + NL + "           \t\tpublic String getOriginalJSONString(String xmlString,String additionRoot,String encoding,boolean isGetWholeJson) throws Exception {" + NL + "    \t\t\t\t\treturn getOriginalJSONString(xmlString, additionRoot, encoding, isGetWholeJson, false);" + NL + "\t\t\t\t}";
  protected final String TEXT_17 = NL + "}" + NL + "\t\t\t" + NL + "\t\t\tOriginalJSONString_";
  protected final String TEXT_18 = " originalJSONString_";
  protected final String TEXT_19 = " = new OriginalJSONString_";
  protected final String TEXT_20 = "();" + NL + "" + NL + "class XML_API_";
  protected final String TEXT_21 = "{" + NL + "\tpublic boolean isDefNull(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "        if (node != null && node instanceof org.dom4j.Element) {" + NL + "        \torg.dom4j.Attribute attri = ((org.dom4j.Element)node).attribute(\"nil\");" + NL + "        \tif(attri != null && (\"true\").equals(attri.getText())){" + NL + "            \treturn true;" + NL + "            }" + NL + "        }" + NL + "        return false;" + NL + "    }" + NL + "" + NL + "    public boolean isMissing(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "        return node == null ? true : false;" + NL + "    }" + NL + "" + NL + "    public boolean isEmpty(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "        if (node != null) {" + NL + "            return node.getText().length() == 0;" + NL + "        }" + NL + "        return false;" + NL + "    }";
  protected final String TEXT_22 = NL + "            public void putUnExtractValue_";
  protected final String TEXT_23 = "(";
  protected final String TEXT_24 = "Struct ";
  protected final String TEXT_25 = ",";
  protected final String TEXT_26 = "){";
  protected final String TEXT_27 = NL + "                ";
  protected final String TEXT_28 = ".";
  protected final String TEXT_29 = " = ";
  protected final String TEXT_30 = ";";
  protected final String TEXT_31 = NL + "            }";
  protected final String TEXT_32 = NL + "            public void putExtractValue_";
  protected final String TEXT_33 = NL + "                String xmlStr_";
  protected final String TEXT_34 = ",org.dom4j.Node temp_";
  protected final String TEXT_35 = ",String loopQuery_";
  protected final String TEXT_36 = ",java.util.HashMap xmlNameSpaceMap_";
  protected final String TEXT_37 = ",org.dom4j.Node node_";
  protected final String TEXT_38 = "," + NL + "                    String str_";
  protected final String TEXT_39 = ",XML_API_";
  protected final String TEXT_40 = " xml_api_";
  protected final String TEXT_41 = ",OriginalJSONString_";
  protected final String TEXT_42 = ",ConvertJSONString_";
  protected final String TEXT_43 = ",boolean isGetWholeJson_";
  protected final String TEXT_44 = " ) throws java.lang.Exception {";
  protected final String TEXT_45 = NL + "                    \tisGetWholeJson_";
  protected final String TEXT_46 = "  = true;";
  protected final String TEXT_47 = NL + "                org.dom4j.XPath xTmp";
  protected final String TEXT_48 = "_";
  protected final String TEXT_49 = " = temp_";
  protected final String TEXT_50 = ".createXPath(";
  protected final String TEXT_51 = ");" + NL + "                xTmp";
  protected final String TEXT_52 = ".setNamespaceURIs(xmlNameSpaceMap_";
  protected final String TEXT_53 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_54 = NL + "                Object obj";
  protected final String TEXT_55 = " = xTmp";
  protected final String TEXT_56 = ".evaluate(temp_";
  protected final String TEXT_57 = ");" + NL + "                if(obj";
  protected final String TEXT_58 = " instanceof String || obj";
  protected final String TEXT_59 = " instanceof Number){" + NL + "                    node_";
  protected final String TEXT_60 = ";" + NL + "                    str_";
  protected final String TEXT_61 = " = String.valueOf(obj";
  protected final String TEXT_62 = ");" + NL + "                }else{" + NL + "                    node_";
  protected final String TEXT_63 = ".selectSingleNode(temp_";
  protected final String TEXT_64 = ");";
  protected final String TEXT_65 = NL + "\t\t\t\t\t\tif(node_";
  protected final String TEXT_66 = "==null){" + NL + "\t \t\t\t\t\t\tstr_";
  protected final String TEXT_67 = " = null;" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\tstr_";
  protected final String TEXT_68 = " = originalJSONString_";
  protected final String TEXT_69 = ".getOriginalJSONString(node_";
  protected final String TEXT_70 = ".asXML(),cjs_";
  protected final String TEXT_71 = ".getAdditionRoot(),";
  protected final String TEXT_72 = ",isGetWholeJson_";
  protected final String TEXT_73 = ");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tisGetWholeJson_";
  protected final String TEXT_74 = " = false;";
  protected final String TEXT_75 = NL + "                        str_";
  protected final String TEXT_76 = ".valueOf(temp_";
  protected final String TEXT_77 = NL + "                }";
  protected final String TEXT_78 = NL + "\t\t\t\t\t\tString xmlStrTemp";
  protected final String TEXT_79 = " = \"\";" + NL + "\t\t\t\t\t\tfor(Object tempNode_";
  protected final String TEXT_80 = " : xTmp";
  protected final String TEXT_81 = ".selectNodes(temp_";
  protected final String TEXT_82 = ")){" + NL + "\t\t\t\t\t\t\tnode_";
  protected final String TEXT_83 = " = (org.dom4j.Node)tempNode_";
  protected final String TEXT_84 = ";" + NL + "\t\t\t\t\t\t\txmlStrTemp";
  protected final String TEXT_85 = " += node_";
  protected final String TEXT_86 = ".asXML();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tif(\"\".equals(xmlStrTemp";
  protected final String TEXT_87 = ")){" + NL + "\t\t\t\t\t\t\tstr_";
  protected final String TEXT_88 = ".getOriginalJSONString(xmlStrTemp";
  protected final String TEXT_89 = ",cjs_";
  protected final String TEXT_90 = ", true);" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tisGetWholeJson_";
  protected final String TEXT_91 = " = false;" + NL + "                \t";
  protected final String TEXT_92 = NL + "\t\t\t\t\t\tjava.util.List<String> xmlListTemp";
  protected final String TEXT_93 = " = new java.util.ArrayList<String>();" + NL + "\t\t\t\t\t\tfor(Object tempNode_";
  protected final String TEXT_94 = ")){" + NL + "\t\t\t\t\t\t\txmlListTemp";
  protected final String TEXT_95 = ".add(((org.dom4j.Node)tempNode_";
  protected final String TEXT_96 = ").getStringValue());" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_97 = NL + "                                    ";
  protected final String TEXT_98 = " = str_";
  protected final String TEXT_99 = NL + "                                    if(xml_api_";
  protected final String TEXT_100 = ".isDefNull(node_";
  protected final String TEXT_101 = ")){";
  protected final String TEXT_102 = NL + "                                        ";
  protected final String TEXT_103 = " =null;" + NL + "                                    }else if(xml_api_";
  protected final String TEXT_104 = ".isEmpty(node_";
  protected final String TEXT_105 = " =\"\";" + NL + "                                    }else if(xml_api_";
  protected final String TEXT_106 = ".isMissing(node_";
  protected final String TEXT_107 = " )){ ";
  protected final String TEXT_108 = " =";
  protected final String TEXT_109 = ";" + NL + "                                    }else{";
  protected final String TEXT_110 = NL + "\t\t\t\t\t\t\t\t\tif(xml_api_";
  protected final String TEXT_111 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_112 = " =\"\";" + NL + "\t\t\t\t\t\t\t\t\t}else if(xml_api_";
  protected final String TEXT_113 = " )){ " + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_114 = ";" + NL + "\t\t\t\t\t\t\t\t\t}else{";
  protected final String TEXT_115 = "\t" + NL + "                                \tif(xml_api_";
  protected final String TEXT_116 = ")){" + NL + "                                    \t";
  protected final String TEXT_117 = " = null;" + NL + "                                \t}else if(xml_api_";
  protected final String TEXT_118 = ") || xml_api_";
  protected final String TEXT_119 = ";" + NL + "                                \t}else{";
  protected final String TEXT_120 = NL + "\t\t\t\t\t\t\t\t\t\tif(xml_api_";
  protected final String TEXT_121 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_122 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t}else{";
  protected final String TEXT_123 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_124 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_125 = " = ParserUtils.parseTo_Date(str_";
  protected final String TEXT_126 = ", ";
  protected final String TEXT_127 = " = ParserUtils.parseTo_";
  protected final String TEXT_128 = "(str_";
  protected final String TEXT_129 = NL + "\t\t\t\t\t\t\t\t\t}";
  protected final String TEXT_130 = NL + "\t\t\t\t\t\t\t\tif(xmlListTemp";
  protected final String TEXT_131 = ".isEmpty()){" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_132 = " = null;\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_133 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_134 = " = xmlListTemp";
  protected final String TEXT_135 = ".toString();" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_136 = ";" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_137 = NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_138 = NL + "            public void putRejectValueBeforeExtract_";
  protected final String TEXT_139 = NL + "            public void putRejectValueAfterExtract_";
  protected final String TEXT_140 = NL + "}" + NL + "" + NL + "String xmlStr_";
  protected final String TEXT_141 = " = \"\";" + NL + "" + NL + "XML_API_";
  protected final String TEXT_142 = " = new XML_API_";
  protected final String TEXT_143 = "();" + NL + " ";
  protected final String TEXT_144 = NL + NL + "class JsonPathCache_";
  protected final String TEXT_145 = " {" + NL + "\tfinal java.util.Map<String,com.jayway.jsonpath.JsonPath> jsonPathString2compiledJsonPath = new java.util.HashMap<String,com.jayway.jsonpath.JsonPath>();" + NL + "\t" + NL + "\tpublic com.jayway.jsonpath.JsonPath getCompiledJsonPath(String jsonPath) {" + NL + "\t\tif(jsonPathString2compiledJsonPath.containsKey(jsonPath)) {" + NL + "\t\t\treturn jsonPathString2compiledJsonPath.get(jsonPath);" + NL + "\t\t} else {" + NL + "\t\t\tcom.jayway.jsonpath.JsonPath compiledLoopPath = com.jayway.jsonpath.JsonPath.compile(jsonPath);" + NL + "\t\t\tjsonPathString2compiledJsonPath.put(jsonPath,compiledLoopPath);" + NL + "\t\t\treturn compiledLoopPath;" + NL + "\t\t}" + NL + "\t}" + NL + "}" + NL + "" + NL + "JsonPathCache_";
  protected final String TEXT_146 = " jsonPathCache_";
  protected final String TEXT_147 = " = new JsonPathCache_";
  protected final String TEXT_148 = "();" + NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	int schemaOptNum=100;
    String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
    if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
        schemaOptNum  = Integer.parseInt(schemaOptNumStr);
    }
    String jsonField = ElementParameterParser.getValue(node, "__JSONFIELD__");

    String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
    boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;
    String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
    
    IConnection inConn = null;
    List< ? extends IConnection> inConns = node.getIncomingConnections();
    List<IMetadataColumn> inColumns = null;
    if (inConns!=null) {
        for (IConnection incomingConn : inConns) {
            if (incomingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
                inConn = incomingConn;
                inColumns = inConn.getMetadataTable().getListColumns();
                break;
            }
        }
    }
    
    String readBy = ElementParameterParser.getValue(node, "__READ_BY__");

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    if(!"JSONPATH".equals(readBy)) {
	List<Map<String, String>> mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MAPPING__");
	String loopQuery = ElementParameterParser.getValue(node, "__LOOP_QUERY__");

    stringBuffer.append(TEXT_4);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    
        String nodeChecked = null;
        boolean hasNodeCheck = false;
        for(int i = 0 ;i<mapping.size();i++){
            nodeChecked = mapping.get(i).get("NODECHECK");
            if("true".equals(nodeChecked)){
                hasNodeCheck = true;
                break;
            }
        }
        if(hasNodeCheck){//----start has nodeCheck

    stringBuffer.append(TEXT_16);
    
        }//----end has nodeCheck

    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    
String rejectConnName = "";
List<IMetadataColumn> rejectColumnList = null;
List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
if(rejectConns != null && rejectConns.size() > 0) {
    IConnection rejectConn = rejectConns.get(0);
    rejectColumnList = rejectConn.getMetadataTable().getListColumns();
    rejectConnName = rejectConn.getName(); 
}

IConnection outConn = null;
String firstConnName = "";
List< ? extends IConnection> outConns = node.getOutgoingSortedConnections();
if(outConns!=null){
    for (IConnection conn : outConns) {
        if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
            outConn = conn;
            firstConnName = outConn.getName();
            break;
        }
    }
}
if (outConn!=null) {
    if(schemaOptNum < mapping.size()){//whether to optimize
        if(inConn!=null){
            int unExtractColNo=0;
            for (int i=0;i<mapping.size();i++) { 
                if (mapping.get(i).get("SCHEMA_COLUMN")!=null) {
                    String query = mapping.get(i).get("QUERY");
                    if(query==null || query.trim().length()<1){
                        for(IMetadataColumn inColumn:inColumns) {
                            if (inColumn.getLabel().compareTo(mapping.get(i).get("SCHEMA_COLUMN"))==0) {
                                if(unExtractColNo%schemaOptNum==0){

    stringBuffer.append(TEXT_22);
    stringBuffer.append(unExtractColNo/schemaOptNum);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(outConn));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(inConn));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_26);
    
                                }

    stringBuffer.append(TEXT_27);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(inConn.getName() );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_30);
    
                                if((unExtractColNo+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_31);
    
                                }
                                unExtractColNo++;
                                break;
                            }
                        }
                    }
                }
            }
            if(unExtractColNo>0&&(unExtractColNo%schemaOptNum)>0){

    stringBuffer.append(TEXT_31);
    
            }
        }
        int extractColNo=0;
        for (int i=0;i<mapping.size();i++) {  //for S_0
            String query = mapping.get(i).get("QUERY");
            String nodeCheck = mapping.get(i).get("NODECHECK");
            boolean isArrayCheck = "true".equals(mapping.get(i).get("ISARRAY"));
            if(query!=null && query.trim().length()>0){  // if S_0_0
                if(extractColNo%schemaOptNum==0){

    stringBuffer.append(TEXT_32);
    stringBuffer.append(extractColNo/schemaOptNum);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(outConn));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_25);
    if(inConn!=null){
    stringBuffer.append(NodeUtil.getPrivateConnClassName(inConn));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_25);
    }
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    
                }
             	if("true".equals(nodeCheck)){
                	if((".").equals(query.substring(1,query.length()-1)) && ("/").equals(loopQuery.substring(1,loopQuery.length()-1))){

    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    
                	}
            	}

    stringBuffer.append(TEXT_47);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    
                if(!isArrayCheck){
                
    stringBuffer.append(TEXT_54);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    
                    if(("true").equals(nodeCheck)){

    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    
                    }else{

    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    
                    }

    stringBuffer.append(TEXT_77);
    
}else{
                	if(("true").equals(nodeCheck)){
					
    stringBuffer.append(TEXT_78);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    
                	}else{
					
    stringBuffer.append(TEXT_92);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    
                	}
                }
                for(IMetadataColumn column:outConn.getMetadataTable().getListColumns()) { // for S_0_0_0
                    if (mapping.get(i).get("SCHEMA_COLUMN")!=null) { // if S_0_0_0_0
                        if (column.getLabel().compareTo(mapping.get(i).get("SCHEMA_COLUMN"))==0) { //if S_0_0_0_0_0
                            
                            String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
                            JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                            String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                            
                            boolean isNotSetDefault = false;
                            String defaultValue=column.getDefault();
                            if(defaultValue!=null){
                                isNotSetDefault = defaultValue.trim().length()==0;
                            }else{
                                isNotSetDefault=true;
                            }
                            
                            if(("true").equals(nodeCheck)){

    stringBuffer.append(TEXT_97);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    
                                continue;
                            }
                            if(!isArrayCheck){
                            if(javaType == JavaTypesManager.STRING){
								if(column.isNullable()){

    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(isNotSetDefault?null:column.getDefault());
    stringBuffer.append(TEXT_109);
    
								}else{ // column.isNullable()

    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(isNotSetDefault?JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate):column.getDefault());
    stringBuffer.append(TEXT_114);
    
								}
                            }else{ // other type
								if(column.isNullable()){

    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(isNotSetDefault?null:column.getDefault());
    stringBuffer.append(TEXT_119);
    
								}else{ // column.isNullable()

    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(isNotSetDefault?JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate):column.getDefault());
    stringBuffer.append(TEXT_122);
    
								}
							}
							if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_123);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_98);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_30);
    
							} else {
								if (javaType == JavaTypesManager.DATE) {

    stringBuffer.append(TEXT_124);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_125);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_64);
    
								} else {

    stringBuffer.append(TEXT_124);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_127);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_128);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_64);
    
								}
							}

    stringBuffer.append(TEXT_129);
    
							}else{
							
    stringBuffer.append(TEXT_130);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_132);
    
									if(javaType == JavaTypesManager.STRING){
									
    stringBuffer.append(TEXT_133);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    
									}else if(javaType == JavaTypesManager.LIST || javaType == JavaTypesManager.OBJECT){
									
    stringBuffer.append(TEXT_133);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    
									}
									
    stringBuffer.append(TEXT_137);
    
							}
                            break;
                        } // if S_0_0_0_0_1
                    } // if S_0_0_0_1
                } // for S_0_0_1
                if((extractColNo+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_31);
    
                }
                extractColNo++;
            }// if S_0_1
        } // for S_1
        if(extractColNo >0&&(extractColNo%schemaOptNum)>0){

    stringBuffer.append(TEXT_31);
    
        }
        if(!dieOnError && !("").equals(rejectConnName) && rejectColumnList != null && rejectColumnList.size() > 0) {//reject before extract
            if(inConn!=null){
                int columnNo=0;
                for(IMetadataColumn column : outConn.getMetadataTable().getListColumns()) {
                    if(!jsonField.equals(column.getLabel())){
                        for(IMetadataColumn inColumn : inConn.getMetadataTable().getListColumns()){
                            if(inColumn.getLabel().equals(column.getLabel())){
                                if(columnNo%schemaOptNum==0){

    stringBuffer.append(TEXT_138);
    stringBuffer.append(columnNo/schemaOptNum);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(inConn));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_26);
    
                                }

    stringBuffer.append(TEXT_27);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(inConn.getName() );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_30);
    
                                if((columnNo+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_31);
    
                                }
                                columnNo++;
                                break;
                            }
                        }
                    }
                }
                if(columnNo>0&&(columnNo%schemaOptNum)>0){

    stringBuffer.append(TEXT_31);
    
                }
            }
        }//reject before extract
        
        if(!dieOnError && !("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {//reject extract
            int columnNo=0;
            for(IMetadataColumn column : outConn.getMetadataTable().getListColumns()) {
                if(columnNo%schemaOptNum==0){

    stringBuffer.append(TEXT_139);
    stringBuffer.append(columnNo/schemaOptNum);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_26);
    
                }

    stringBuffer.append(TEXT_27);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_30);
    
                if((columnNo+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_31);
    
                }
                columnNo++;
            }
            if(columnNo>0&&(columnNo%schemaOptNum)>0){

    stringBuffer.append(TEXT_31);
    
            }
        }//reject extract
        
    }//whether to optimize
}

    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    } else {
	List<Map<String, String>> mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MAPPING_4_JSONPATH__");
	String loopQuery = ElementParameterParser.getValue(node, "__JSON_LOOP_QUERY__");

    stringBuffer.append(TEXT_4);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    }
    return stringBuffer.toString();
  }
}
