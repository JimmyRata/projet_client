package org.talend.designer.codegen.translators.processing.fields;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.BlockCode;
import java.util.Map;
import java.util.List;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

public class TExtractJSONFieldsMainJava
{
  protected static String nl;
  public static synchronized TExtractJSONFieldsMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TExtractJSONFieldsMainJava result = new TExtractJSONFieldsMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "            if(";
  protected final String TEXT_3 = ".";
  protected final String TEXT_4 = "!=null){// C_01" + NL + "                jsonStr_";
  protected final String TEXT_5 = " = ";
  protected final String TEXT_6 = ".toString();";
  protected final String TEXT_7 = NL + "   ";
  protected final String TEXT_8 = NL;
  protected final String TEXT_9 = " = null;";
  protected final String TEXT_10 = NL + "\t";
  protected final String TEXT_11 = NL + "    org.dom4j.io.SAXReader reader_";
  protected final String TEXT_12 = " = new org.dom4j.io.SAXReader();" + NL + "    org.dom4j.Document doc_";
  protected final String TEXT_13 = " = null;" + NL + "    java.util.HashMap xmlNameSpaceMap_";
  protected final String TEXT_14 = " = new java.util.HashMap<String, String>();" + NL + "    org.dom4j.XPath x_";
  protected final String TEXT_15 = " = null;" + NL + "    java.util.List<org.dom4j.Node> nodeList_";
  protected final String TEXT_16 = " = null;" + NL + "    boolean isStructError_";
  protected final String TEXT_17 = " = true;" + NL + "" + NL + "    String loopQuery_";
  protected final String TEXT_18 = " =  ";
  protected final String TEXT_19 = " ;" + NL + "    String oraginalJsonStr_";
  protected final String TEXT_20 = " = jsonStr_";
  protected final String TEXT_21 = ";" + NL + "    cjs_";
  protected final String TEXT_22 = ".setJsonString(jsonStr_";
  protected final String TEXT_23 = ");" + NL + "    cjs_";
  protected final String TEXT_24 = ".setLoopString(loopQuery_";
  protected final String TEXT_25 = ");" + NL + "    java.io.ByteArrayInputStream bais_";
  protected final String TEXT_26 = " = null;" + NL + "    java.io.ByteArrayOutputStream  baos_";
  protected final String TEXT_27 = " = new java.io.ByteArrayOutputStream();" + NL + "    try {" + NL + "        cjs_";
  protected final String TEXT_28 = ".generate();" + NL + "        jsonStr_";
  protected final String TEXT_29 = " = cjs_";
  protected final String TEXT_30 = ".getJsonString4XML();" + NL + "        loopQuery_";
  protected final String TEXT_31 = ".getLoopString4XML();" + NL + "        bais_";
  protected final String TEXT_32 = " = new ByteArrayInputStream(jsonStr_";
  protected final String TEXT_33 = ".getBytes(";
  protected final String TEXT_34 = "));" + NL + "        javax.xml.stream.XMLEventReader xmlEventReader_";
  protected final String TEXT_35 = " = jsonXMLInputFactory_";
  protected final String TEXT_36 = ".createXMLEventReader(bais_";
  protected final String TEXT_37 = ");" + NL + "        javax.xml.stream.XMLEventWriter xmLEventWriter_";
  protected final String TEXT_38 = " = xmlOutputFactory_";
  protected final String TEXT_39 = ".createXMLEventWriter(baos_";
  protected final String TEXT_40 = ",";
  protected final String TEXT_41 = ");" + NL + "        xmLEventWriter_";
  protected final String TEXT_42 = ".add(xmlEventReader_";
  protected final String TEXT_43 = ");" + NL + "        //convert json string to xml" + NL + "        xmlStr_";
  protected final String TEXT_44 = " = baos_";
  protected final String TEXT_45 = ".toString();  " + NL + "        xmLEventWriter_";
  protected final String TEXT_46 = ".close();" + NL + "        xmlEventReader_";
  protected final String TEXT_47 = ".close();" + NL + "    " + NL + "        doc_";
  protected final String TEXT_48 = "= reader_";
  protected final String TEXT_49 = ".read(new java.io.StringReader(xmlStr_";
  protected final String TEXT_50 = "));" + NL + "        x_";
  protected final String TEXT_51 = " = doc_";
  protected final String TEXT_52 = ".createXPath(loopQuery_";
  protected final String TEXT_53 = ");" + NL + "        x_";
  protected final String TEXT_54 = ".setNamespaceURIs(xmlNameSpaceMap_";
  protected final String TEXT_55 = "); " + NL + "        nodeList_";
  protected final String TEXT_56 = " = (java.util.List<org.dom4j.Node>)x_";
  protected final String TEXT_57 = ".selectNodes(doc_";
  protected final String TEXT_58 = ");" + NL + "        isStructError_";
  protected final String TEXT_59 = " = false;" + NL + "        " + NL + "    }catch(java.lang.Exception ex_";
  protected final String TEXT_60 = "){";
  protected final String TEXT_61 = NL + "        throw(ex_";
  protected final String TEXT_62 = ");";
  protected final String TEXT_63 = NL + "\t\t\tlog.error(\"";
  protected final String TEXT_64 = " - \" + ex_";
  protected final String TEXT_65 = ".getMessage());" + NL + "\t\t";
  protected final String TEXT_66 = NL + "    ";
  protected final String TEXT_67 = " = new ";
  protected final String TEXT_68 = "Struct();";
  protected final String TEXT_69 = NL + "            xml_api_";
  protected final String TEXT_70 = ".putRejectValueBeforeExtract_";
  protected final String TEXT_71 = "(";
  protected final String TEXT_72 = ";";
  protected final String TEXT_73 = ".errorJSONField = oraginalJsonStr_";
  protected final String TEXT_74 = ".errorMessage = ex_";
  protected final String TEXT_75 = ".getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_76 = NL + "    System.err.println(ex_";
  protected final String TEXT_77 = ".getMessage());";
  protected final String TEXT_78 = NL + "    }finally {" + NL + "        baos_";
  protected final String TEXT_79 = ".close();" + NL + "        if(bais_";
  protected final String TEXT_80 = "!=null){" + NL + "            bais_";
  protected final String TEXT_81 = ".close();" + NL + "        }" + NL + "    }" + NL + "    " + NL + "    org.dom4j.Node node_";
  protected final String TEXT_82 = " = null;" + NL + "    String str_";
  protected final String TEXT_83 = " = \"\";" + NL + "    for(int i_";
  protected final String TEXT_84 = "=0; isStructError_";
  protected final String TEXT_85 = " || (nodeList_";
  protected final String TEXT_86 = "!=null && i_";
  protected final String TEXT_87 = " < nodeList_";
  protected final String TEXT_88 = ".size());i_";
  protected final String TEXT_89 = "++){" + NL + "        " + NL + "        if(!isStructError_";
  protected final String TEXT_90 = NL + "            ";
  protected final String TEXT_91 = "Struct();" + NL + "        " + NL + "            org.dom4j.Node temp_";
  protected final String TEXT_92 = " = nodeList_";
  protected final String TEXT_93 = ".get(i_";
  protected final String TEXT_94 = ");" + NL + "    " + NL + "            nb_line_";
  protected final String TEXT_95 = "++; " + NL + "            try{";
  protected final String TEXT_96 = ".putUnExtractValue_";
  protected final String TEXT_97 = ".putExtractValue_";
  protected final String TEXT_98 = "xmlStr_";
  protected final String TEXT_99 = ",temp_";
  protected final String TEXT_100 = ",loopQuery_";
  protected final String TEXT_101 = ",xmlNameSpaceMap_";
  protected final String TEXT_102 = ",node_";
  protected final String TEXT_103 = ",str_";
  protected final String TEXT_104 = ",xml_api_";
  protected final String TEXT_105 = ",originalJSONString_";
  protected final String TEXT_106 = ",cjs_";
  protected final String TEXT_107 = ",isGetWholeJson_";
  protected final String TEXT_108 = NL + "\t\t\t\t\t\tisGetWholeJson_";
  protected final String TEXT_109 = "  = true;";
  protected final String TEXT_110 = NL + "                org.dom4j.XPath xTmp";
  protected final String TEXT_111 = "_";
  protected final String TEXT_112 = " = temp_";
  protected final String TEXT_113 = ".createXPath(";
  protected final String TEXT_114 = ");" + NL + "                xTmp";
  protected final String TEXT_115 = NL + "\t                Object obj";
  protected final String TEXT_116 = " = xTmp";
  protected final String TEXT_117 = ".evaluate(temp_";
  protected final String TEXT_118 = ");" + NL + "\t                if(obj";
  protected final String TEXT_119 = " instanceof String || obj";
  protected final String TEXT_120 = " instanceof Number){" + NL + "\t                    node_";
  protected final String TEXT_121 = ";" + NL + "\t                    str_";
  protected final String TEXT_122 = " = String.valueOf(obj";
  protected final String TEXT_123 = ");" + NL + "\t                }else{" + NL + "                    \tnode_";
  protected final String TEXT_124 = ".selectSingleNode(temp_";
  protected final String TEXT_125 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_126 = NL + "\t\t\t\t\t\t\tif(node_";
  protected final String TEXT_127 = "==null){" + NL + "\t\t\t\t\t\t\t\tstr_";
  protected final String TEXT_128 = " = null;" + NL + "\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\tstr_";
  protected final String TEXT_129 = " = originalJSONString_";
  protected final String TEXT_130 = ".getOriginalJSONString(node_";
  protected final String TEXT_131 = ".asXML(),cjs_";
  protected final String TEXT_132 = ".getAdditionRoot(),";
  protected final String TEXT_133 = ");" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tisGetWholeJson_";
  protected final String TEXT_134 = " = false;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_135 = NL + "\t                        str_";
  protected final String TEXT_136 = ".valueOf(temp_";
  protected final String TEXT_137 = NL + "\t                }" + NL + "\t\t\t\t";
  protected final String TEXT_138 = NL + "\t\t\t\t\t\tString xmlStrTemp";
  protected final String TEXT_139 = " = \"\";" + NL + "\t\t\t\t\t\tfor(Object tempNode_";
  protected final String TEXT_140 = " : xTmp";
  protected final String TEXT_141 = ".selectNodes(temp_";
  protected final String TEXT_142 = ")){" + NL + "\t\t\t\t\t\t\tnode_";
  protected final String TEXT_143 = " = (org.dom4j.Node)tempNode_";
  protected final String TEXT_144 = ";" + NL + "\t\t\t\t\t\t\txmlStrTemp";
  protected final String TEXT_145 = " += node_";
  protected final String TEXT_146 = ".asXML();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tif(\"\".equals(xmlStrTemp";
  protected final String TEXT_147 = ")){" + NL + "\t\t\t\t\t\t\tstr_";
  protected final String TEXT_148 = " = null;" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\tstr_";
  protected final String TEXT_149 = ".getOriginalJSONString(xmlStrTemp";
  protected final String TEXT_150 = ", true);" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tisGetWholeJson_";
  protected final String TEXT_151 = " = false;" + NL + "                \t";
  protected final String TEXT_152 = NL + "\t\t\t\t\t\tjava.util.List<String> xmlListTemp";
  protected final String TEXT_153 = " = new java.util.ArrayList<String>();" + NL + "\t\t\t\t\t\tfor(Object tempNode_";
  protected final String TEXT_154 = ")){" + NL + "\t\t\t\t\t\t\txmlListTemp";
  protected final String TEXT_155 = ".add(((org.dom4j.Node)tempNode_";
  protected final String TEXT_156 = ").getStringValue());" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_157 = NL + "                                ";
  protected final String TEXT_158 = " = str_";
  protected final String TEXT_159 = ";" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_160 = NL + "\t                                    if(xml_api_";
  protected final String TEXT_161 = ".isDefNull(node_";
  protected final String TEXT_162 = ")){" + NL + "\t                                        ";
  protected final String TEXT_163 = " = null;" + NL + "\t                                    }else if(xml_api_";
  protected final String TEXT_164 = ".isEmpty(node_";
  protected final String TEXT_165 = " = \"\";" + NL + "\t                                    }else if(xml_api_";
  protected final String TEXT_166 = ".isMissing(node_";
  protected final String TEXT_167 = " )){ " + NL + "\t                                        ";
  protected final String TEXT_168 = ";" + NL + "\t                                    }else{" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_169 = NL + "\t\t\t\t\t\t\t\t\t\tif(xml_api_";
  protected final String TEXT_170 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_171 = " =\"\";" + NL + "\t\t\t\t\t\t\t\t\t\t}else if(xml_api_";
  protected final String TEXT_172 = " )){ " + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_173 = " =";
  protected final String TEXT_174 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_175 = "  " + NL + "\t                                \tif(xml_api_";
  protected final String TEXT_176 = ")){" + NL + "\t                                    \t";
  protected final String TEXT_177 = " = null;" + NL + "\t                                \t}else if(xml_api_";
  protected final String TEXT_178 = ") || xml_api_";
  protected final String TEXT_179 = ";" + NL + "\t                                \t}else{" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_180 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_181 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_182 = " = ParserUtils.parseTo_Date(str_";
  protected final String TEXT_183 = ", ";
  protected final String TEXT_184 = ".toString().getBytes();";
  protected final String TEXT_185 = " = ParserUtils.parseTo_";
  protected final String TEXT_186 = "(str_";
  protected final String TEXT_187 = ");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_188 = NL + "\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_189 = NL + "\t\t\t\t\t\t\t\tif(xmlListTemp";
  protected final String TEXT_190 = ".isEmpty()){" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_191 = " = null;\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_192 = " = xmlListTemp";
  protected final String TEXT_193 = ".toString();" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_194 = ";" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_195 = NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_196 = NL + "}catch(java.lang.Exception ex_";
  protected final String TEXT_197 = NL + "    throw(ex_";
  protected final String TEXT_198 = ".putRejectValueAfterExtract_";
  protected final String TEXT_199 = NL + "     ";
  protected final String TEXT_200 = NL + "        }" + NL + "    }" + NL + "    " + NL + "    isStructError_";
  protected final String TEXT_201 = " = false;" + NL;
  protected final String TEXT_202 = NL + "\tlog.debug(\"";
  protected final String TEXT_203 = " - Extracting the record \" + nb_line_";
  protected final String TEXT_204 = " + \".\");";
  protected final String TEXT_205 = " ";
  protected final String TEXT_206 = NL + NL + "String loopPath_";
  protected final String TEXT_207 = ";" + NL + "java.util.List<Object> resultset_";
  protected final String TEXT_208 = " = new java.util.ArrayList<Object>();" + NL + "" + NL + "boolean isStructError_";
  protected final String TEXT_209 = " = true;" + NL + "com.jayway.jsonpath.ReadContext document_";
  protected final String TEXT_210 = " = null;" + NL + "try {" + NL + "\tdocument_";
  protected final String TEXT_211 = " = com.jayway.jsonpath.JsonPath.parse(jsonStr_";
  protected final String TEXT_212 = ");" + NL + "\tcom.jayway.jsonpath.JsonPath compiledLoopPath_";
  protected final String TEXT_213 = " = jsonPathCache_";
  protected final String TEXT_214 = ".getCompiledJsonPath(loopPath_";
  protected final String TEXT_215 = ");" + NL + "\tObject result_";
  protected final String TEXT_216 = " = document_";
  protected final String TEXT_217 = ".read(compiledLoopPath_";
  protected final String TEXT_218 = ",net.minidev.json.JSONObject.class);" + NL + "\tif (result_";
  protected final String TEXT_219 = " instanceof net.minidev.json.JSONArray) {" + NL + "\t\tresultset_";
  protected final String TEXT_220 = " = (net.minidev.json.JSONArray) result_";
  protected final String TEXT_221 = ";" + NL + "\t} else {" + NL + "\t\tresultset_";
  protected final String TEXT_222 = ".add(result_";
  protected final String TEXT_223 = ");" + NL + "\t}" + NL + "\t" + NL + "\tisStructError_";
  protected final String TEXT_224 = " = false;" + NL + "} catch (java.lang.Exception ex_";
  protected final String TEXT_225 = ") {";
  protected final String TEXT_226 = NL + "\tthrow(ex_";
  protected final String TEXT_227 = NL + "    \t";
  protected final String TEXT_228 = "Struct();" + NL + "\t    ";
  protected final String TEXT_229 = ".errorJSONField = jsonStr_";
  protected final String TEXT_230 = ";" + NL + "    \t";
  protected final String TEXT_231 = NL + "\t\t";
  protected final String TEXT_232 = NL + "\t\tlog.error(\"";
  protected final String TEXT_233 = NL + "\t\tSystem.err.println(ex_";
  protected final String TEXT_234 = NL + "}" + NL + "" + NL + "String jsonPath_";
  protected final String TEXT_235 = " = null;" + NL + "com.jayway.jsonpath.JsonPath compiledJsonPath_";
  protected final String TEXT_236 = " = null;" + NL + "" + NL + "Object value_";
  protected final String TEXT_237 = " = null;" + NL + "" + NL + "Object root_";
  protected final String TEXT_238 = " = null;" + NL + "for(int i_";
  protected final String TEXT_239 = " || (i_";
  protected final String TEXT_240 = " < resultset_";
  protected final String TEXT_241 = "++){" + NL + "\tif(!isStructError_";
  protected final String TEXT_242 = "){" + NL + "\t\tObject row_";
  protected final String TEXT_243 = " = resultset_";
  protected final String TEXT_244 = "Struct();" + NL + "\tnb_line_";
  protected final String TEXT_245 = "++;" + NL + "\ttry {";
  protected final String TEXT_246 = NL + "        \t\t";
  protected final String TEXT_247 = NL + "\t\tjsonPath_";
  protected final String TEXT_248 = ";" + NL + "\t\tcompiledJsonPath_";
  protected final String TEXT_249 = ".getCompiledJsonPath(jsonPath_";
  protected final String TEXT_250 = ");" + NL + "\t\t" + NL + "\t\ttry {" + NL + "\t\t    ";
  protected final String TEXT_251 = NL + "\t\t        value_";
  protected final String TEXT_252 = " = compiledJsonPath_";
  protected final String TEXT_253 = ".read(row_";
  protected final String TEXT_254 = ");" + NL + "\t\t    ";
  protected final String TEXT_255 = NL + "\t\t        if(jsonPath_";
  protected final String TEXT_256 = ".startsWith(\"$\")){" + NL + "\t\t            if(root_";
  protected final String TEXT_257 = " == null){" + NL + "\t\t                root_";
  protected final String TEXT_258 = ".read(jsonPathCache_";
  protected final String TEXT_259 = ".getCompiledJsonPath(\"$\"));" + NL + "\t\t\t\t\t   }" + NL + "\t\t            value_";
  protected final String TEXT_260 = ".read(root_";
  protected final String TEXT_261 = ");" + NL + "\t\t        }else{" + NL + "\t\t            value_";
  protected final String TEXT_262 = ");" + NL + "\t\t        }";
  protected final String TEXT_263 = NL + "\t\t\t\t";
  protected final String TEXT_264 = " = value_";
  protected final String TEXT_265 = " == null ? ";
  protected final String TEXT_266 = NL + NL + " : value_";
  protected final String TEXT_267 = NL + "\t\t\t\tif(value_";
  protected final String TEXT_268 = " != null && !value_";
  protected final String TEXT_269 = ".toString().isEmpty()) {";
  protected final String TEXT_270 = NL + "\t\t\t\t\t";
  protected final String TEXT_271 = " = ParserUtils.parseTo_Date(value_";
  protected final String TEXT_272 = ".toString(), ";
  protected final String TEXT_273 = NL + "        \t\t    ";
  protected final String TEXT_274 = " = ParserUtils.parseTo_List(value_";
  protected final String TEXT_275 = ".toString(),\",\");";
  protected final String TEXT_276 = NL + "                    ";
  protected final String TEXT_277 = "(value_";
  protected final String TEXT_278 = ".toString());";
  protected final String TEXT_279 = NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\t";
  protected final String TEXT_280 = NL + NL + ";" + NL + "\t\t\t\t}";
  protected final String TEXT_281 = NL + "\t\t} catch (com.jayway.jsonpath.PathNotFoundException e_";
  protected final String TEXT_282 = ") {" + NL + "\t\t\t";
  protected final String TEXT_283 = NL + NL + ";" + NL + "\t\t}";
  protected final String TEXT_284 = "\t" + NL + "\t} catch (java.lang.Exception ex_";
  protected final String TEXT_285 = NL + "    \tthrow(ex_";
  protected final String TEXT_286 = NL + "    \t\t";
  protected final String TEXT_287 = NL + " \t\t\t";
  protected final String TEXT_288 = NL + "\t\t    ";
  protected final String TEXT_289 = ";" + NL + "\t\t    ";
  protected final String TEXT_290 = NL + "\t\t    System.err.println(ex_";
  protected final String TEXT_291 = ".getMessage());" + NL + "\t\t    ";
  protected final String TEXT_292 = "\t" + NL + "\t}" + NL + "\t" + NL + "\t}" + NL + "    " + NL + "\tisStructError_";
  protected final String TEXT_293 = " = false;" + NL + "\t";
  protected final String TEXT_294 = NL + "//}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

String cid = node.getUniqueName();
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

String jsonField = ElementParameterParser.getValue(node, "__JSONFIELD__");
String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;
String encoding = ElementParameterParser.getValue(node, "__ENCODING__");

int schemaOptNum=1;
String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
    schemaOptNum  = Integer.parseInt(schemaOptNumStr);
}
//get JSON field content
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
if (inConn!=null) {
    for (IMetadataColumn inputCol : inColumns) {
        if(inputCol.getLabel().equals(jsonField))
        {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(jsonField);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(jsonField);
    stringBuffer.append(TEXT_6);
    
			List<BlockCode> blockCodes = new java.util.ArrayList<BlockCode>(1);
			blockCodes.add(new BlockCode("C_01"));
			((org.talend.core.model.process.AbstractNode) node).setBlocksCodeToClose(blockCodes);
			break;
        }
    }
}

    stringBuffer.append(TEXT_7);
    

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

if(outConns!=null){
    for (IConnection conn : outConns) {
        if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_8);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_9);
    
        }
    }
}

String readBy = ElementParameterParser.getValue(node, "__READ_BY__");

    stringBuffer.append(TEXT_8);
    if(!"JSONPATH".equals(readBy)) {
	List<Map<String, String>> mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MAPPING__");
	String loopQuery = ElementParameterParser.getValue(node, "__LOOP_QUERY__");

    stringBuffer.append(TEXT_10);
    stringBuffer.append(TEXT_8);
    
if (outConn!=null) {

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(loopQuery );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    
    if(dieOnError){

    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    
    }else{
		if(isLog4jEnabled){
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    }
        if(!("").equals(rejectConnName) && rejectColumnList != null && rejectColumnList.size() > 0) {

    stringBuffer.append(TEXT_66);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_68);
    
            if(inConn!=null){
                int columnNo=0;
                for(IMetadataColumn column : outConn.getMetadataTable().getListColumns()) {
                    if(!jsonField.equals(column.getLabel())){
                        for(IMetadataColumn inColumn : inConn.getMetadataTable().getListColumns()){
                            if(inColumn.getLabel().equals(column.getLabel())){
                                if(schemaOptNum < mapping.size()){
                                    if(columnNo%schemaOptNum==0){

    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(columnNo/schemaOptNum);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_62);
    
                                    }
                                    columnNo++;
                                }else{

    stringBuffer.append(TEXT_66);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(inConn.getName() );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_72);
    
                                }
                                break;
                            }
                        }
                    }
                }
            }

    stringBuffer.append(TEXT_66);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_72);
    
        } else if(("").equals(rejectConnName)){

    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    
        }
    }

    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    
if(outConns!=null){
    for (IConnection conn : outConns) {
        if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_90);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_9);
    
        }
    }
}

    stringBuffer.append(TEXT_90);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    
        if(inConn!=null){
            int unExtractColNo=0;
            for (int i=0;i<mapping.size();i++) {
                if (mapping.get(i).get("SCHEMA_COLUMN")!=null) {
                    String query = mapping.get(i).get("QUERY");
                    if(query==null || query.trim().length() < 1 ){
                        for(IMetadataColumn inColumn:inColumns) {
                            if (inColumn.getLabel().compareTo(mapping.get(i).get("SCHEMA_COLUMN"))==0) {
                                if(schemaOptNum < mapping.size()){
                                    if(unExtractColNo%schemaOptNum==0){

    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(unExtractColNo/schemaOptNum);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_62);
    
                                    }
                                    unExtractColNo++;
                                }else{

    stringBuffer.append(TEXT_90);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(inConn.getName() );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_72);
    
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }
        //get the mapping column 
        int extractColNo=0;
        for (int i=0;i<mapping.size();i++) {  //for S_0
            String query = mapping.get(i).get("QUERY");
            String nodeCheck = mapping.get(i).get("NODECHECK");
            boolean isArrayCheck = "true".equals(mapping.get(i).get("ISARRAY"));
            if(schemaOptNum < mapping.size()){
                if(query!=null && query.trim().length()>0){  // if S_0_0
                    if(extractColNo%schemaOptNum==0){

    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(extractColNo/schemaOptNum);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_40);
    if(inConn!=null){
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_40);
    }
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    
                    }
                    extractColNo++;
                }
            }else{
              if(query!=null && query.trim().length()>0){  // if S_0_0
            		if("true".equals(nodeCheck)){
						if((".").equals(query.substring(1,query.length()-1)) && ("/").equals(loopQuery.substring(1,loopQuery.length()-1))){

    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    
						}
					}

    stringBuffer.append(TEXT_110);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    
                if(!isArrayCheck){
                
    stringBuffer.append(TEXT_115);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    
	                    if(("true").equals(nodeCheck)){
						
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    
	                    }else{
						
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    
	                    }
						
    stringBuffer.append(TEXT_137);
    
				}else{
                	if(("true").equals(nodeCheck)){
					
    stringBuffer.append(TEXT_138);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    
                	}else{
					
    stringBuffer.append(TEXT_152);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    
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
							
    stringBuffer.append(TEXT_157);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    
                                continue;
                            }
                            if(!isArrayCheck){
	                            if(javaType == JavaTypesManager.STRING){
									if(column.isNullable()){
									
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(isNotSetDefault?null:column.getDefault());
    stringBuffer.append(TEXT_168);
    
									}else{ // column.isNullable()
									
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(isNotSetDefault?JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate):column.getDefault());
    stringBuffer.append(TEXT_174);
    
									}
	                            }else{ // other type
									if(column.isNullable()){
									
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(isNotSetDefault?null:column.getDefault());
    stringBuffer.append(TEXT_179);
    
									}else{ // column.isNullable()
									
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(isNotSetDefault?JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate):column.getDefault());
    stringBuffer.append(TEXT_174);
    
									}
								}
								if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
								
    stringBuffer.append(TEXT_180);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_158);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_159);
    
								} else {
									if (javaType == JavaTypesManager.DATE) {
									
    stringBuffer.append(TEXT_181);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_182);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_183);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_62);
    
									} else if (javaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_181);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_158);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_184);
    
									} else {

    stringBuffer.append(TEXT_181);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_185);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_186);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_187);
    
									}
								}
								
    stringBuffer.append(TEXT_188);
    
							}else{
							
    stringBuffer.append(TEXT_189);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_191);
    
									if(javaType == JavaTypesManager.STRING){
									
    stringBuffer.append(TEXT_181);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    
									}else if(javaType == JavaTypesManager.LIST || javaType == JavaTypesManager.OBJECT){
									
    stringBuffer.append(TEXT_181);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    
									}
									
    stringBuffer.append(TEXT_195);
    
							}
	                        break;
                        } // if S_0_0_0_0_1
                    } // if S_0_0_0_1
                } // for S_0_0_1
              }// if S_0_1
            }
        } // for S_1
        if(!("").equals(rejectConnName) && rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_66);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_9);
    
        }

    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    
    if(dieOnError){

    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    
    }else{
		if(isLog4jEnabled){
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    }
        if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {

    stringBuffer.append(TEXT_66);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_68);
    
            int columnNo=0;
            for(IMetadataColumn column : outConn.getMetadataTable().getListColumns()) {
                if(schemaOptNum < mapping.size()){
                    if(columnNo%schemaOptNum==0){

    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(columnNo/schemaOptNum);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_62);
    
                    }
                    columnNo++;
                }else{

    stringBuffer.append(TEXT_199);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_72);
    
                }
            }

    stringBuffer.append(TEXT_66);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_9);
    
        } else if(("").equals(rejectConnName)){

    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_9);
    
        } else if(rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_66);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_72);
    
        }
    }

    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    
}

    stringBuffer.append(TEXT_8);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_204);
    }
    stringBuffer.append(TEXT_205);
    } else {
	List<Map<String, String>> mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MAPPING_4_JSONPATH__");
	String loopQuery = ElementParameterParser.getValue(node, "__JSON_LOOP_QUERY__");

    stringBuffer.append(TEXT_10);
    if (outConn ==null ) {
	return stringBuffer.toString();
}

    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(loopQuery);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    
if(dieOnError){

    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    
} else {
    if(!("").equals(rejectConnName) && rejectColumnList != null && rejectColumnList.size() > 0) {

    stringBuffer.append(TEXT_227);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_228);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_72);
    
        if(inConn!=null){
            for(IMetadataColumn column : outConn.getMetadataTable().getListColumns()) {
                if(!jsonField.equals(column.getLabel())){
                    for(IMetadataColumn inColumn : inConn.getMetadataTable().getListColumns()){
                        if(inColumn.getLabel().equals(column.getLabel())){

    stringBuffer.append(TEXT_231);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(inConn.getName() );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_72);
    
                        }
                    }
                }
            }
        }
    } else if(("").equals(rejectConnName)){
    	if(isLog4jEnabled){

    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    
		}

    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    
	}
}

    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    
if(outConns!=null){
    for (IConnection conn : outConns) {
        if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_90);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_9);
    
        }
    }
}

    stringBuffer.append(TEXT_10);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    
boolean useLoopAsRoot = "true".equals(ElementParameterParser.getValue(node, "__USE_LOOP_AS_ROOT__"));
boolean splitList = "true".equals(ElementParameterParser.getValue(node, "__SPLIT_LIST__"));
for (int i=0;i<mapping.size();i++) {
	for(IMetadataColumn column : outConn.getMetadataTable().getListColumns()) {
		String schemaColumn = mapping.get(i).get("SCHEMA_COLUMN");
		if(schemaColumn == null || !column.getLabel().equals(schemaColumn)) {
			continue;
		}
		
		String jsonPath = mapping.get(i).get("QUERY");
	 	if(jsonPath==null || jsonPath.trim().isEmpty()) {//only propagate
	 		for(IMetadataColumn inColumn : inColumns) {
		 		if(inColumn.getLabel().equals(column.getLabel())) {

    stringBuffer.append(TEXT_246);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(inConn.getName() );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(inColumn.getLabel());
    stringBuffer.append(TEXT_72);
    
				}
			}
			continue;
	 	}
	 	
		String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
        JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
        String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
        
        String defaultValue = column.getDefault();
        boolean isNotSetDefault = (defaultValue == null || defaultValue.trim().length()==0);

    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(jsonPath);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    
		    if(useLoopAsRoot){
		    
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    
		    }else{
		    
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    
		    }
        	if(javaType == JavaTypesManager.STRING){

    stringBuffer.append(TEXT_263);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(TEXT_8);
    
	if(column.isNullable()) {

    stringBuffer.append(TEXT_231);
    stringBuffer.append(isNotSetDefault? null: defaultValue);
    
	} else {

    stringBuffer.append(TEXT_231);
    stringBuffer.append(isNotSetDefault ? JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate) : defaultValue);
    
	}

    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
			} else {

    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    
				if(javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_270);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
				} else if(javaType == JavaTypesManager.DATE) {

    stringBuffer.append(TEXT_270);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_62);
    
        		} else if(javaType == JavaTypesManager.LIST && splitList){
        		
    stringBuffer.append(TEXT_273);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    
                } else if (javaType == JavaTypesManager.BYTE_ARRAY) {

    stringBuffer.append(TEXT_276);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    
                } else {

    stringBuffer.append(TEXT_270);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(typeToGenerate );
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    
        		}

    stringBuffer.append(TEXT_279);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_8);
    
	if(column.isNullable()) {

    stringBuffer.append(TEXT_231);
    stringBuffer.append(isNotSetDefault? null: defaultValue);
    
	} else {

    stringBuffer.append(TEXT_231);
    stringBuffer.append(isNotSetDefault ? JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate) : defaultValue);
    
	}

    stringBuffer.append(TEXT_280);
    
        	}

    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_8);
    
	if(column.isNullable()) {

    stringBuffer.append(TEXT_231);
    stringBuffer.append(isNotSetDefault? null: defaultValue);
    
	} else {

    stringBuffer.append(TEXT_231);
    stringBuffer.append(isNotSetDefault ? JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate) : defaultValue);
    
	}

    stringBuffer.append(TEXT_283);
    
	}
}

if(!("").equals(rejectConnName) && rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_10);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_9);
    
}

    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_225);
    
    if(dieOnError){

    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    
    }else{
        if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {

    stringBuffer.append(TEXT_286);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_68);
    
            for(IMetadataColumn column : outConn.getMetadataTable().getListColumns()) {

    stringBuffer.append(TEXT_287);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_72);
    
            }

    stringBuffer.append(TEXT_288);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_289);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_9);
    
        } else if(("").equals(rejectConnName)){
        	if(isLog4jEnabled){

    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    
			}

    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_291);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_9);
    
        } else if(rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_288);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_72);
    
        }
    }

    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_293);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_204);
    }
    stringBuffer.append(TEXT_294);
    }
    stringBuffer.append(TEXT_8);
    stringBuffer.append(TEXT_8);
    return stringBuffer.toString();
  }
}
