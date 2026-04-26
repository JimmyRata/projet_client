package org.talend.designer.codegen.translators.esb.rest;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.codegen.config.NodeConnectionsHelper;
import org.talend.designer.codegen.config.NodeParamsHelper;

public class TRESTClientMainJava
{
  protected static String nl;
  public static synchronized TRESTClientMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRESTClientMainJava result = new TRESTClientMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = " = null;";
  protected final String TEXT_3 = NL + NL + "// expected response body" + NL;
  protected final String TEXT_4 = "javax.ws.rs.core.Response";
  protected final String TEXT_5 = "java.util. Collection<? extends String>";
  protected final String TEXT_6 = "Object";
  protected final String TEXT_7 = " responseDoc_";
  protected final String TEXT_8 = " = null;" + NL + "" + NL + "try {" + NL + "\t// request body" + NL + "\torg.dom4j.Document requestDoc_";
  protected final String TEXT_9 = " = null;" + NL + "\tString requestString_";
  protected final String TEXT_10 = NL + "\t\t\tif (null != ";
  protected final String TEXT_11 = ".body) {" + NL + "\t\t\t\trequestDoc_";
  protected final String TEXT_12 = " = ";
  protected final String TEXT_13 = ".body.getDocument();" + NL + "\t\t\t}";
  protected final String TEXT_14 = NL + "\t\t\trequestString_";
  protected final String TEXT_15 = ".string;";
  protected final String TEXT_16 = NL + NL + "\tObject requestBody_";
  protected final String TEXT_17 = " = requestDoc_";
  protected final String TEXT_18 = " != null ? requestDoc_";
  protected final String TEXT_19 = " : requestString_";
  protected final String TEXT_20 = ";" + NL + "" + NL + "\t";
  protected final String TEXT_21 = NL + NL + "    //resposne class name";
  protected final String TEXT_22 = NL + "\tClass<";
  protected final String TEXT_23 = "?";
  protected final String TEXT_24 = "> responseClass_";
  protected final String TEXT_25 = NL + "\t\t= ";
  protected final String TEXT_26 = ".class;" + NL + "" + NL + "\t// create web client instance" + NL + "\torg.apache.cxf.jaxrs.client.JAXRSClientFactoryBean factoryBean_";
  protected final String TEXT_27 = " =" + NL + "\t\t\tnew org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean();" + NL + "" + NL + "\tboolean inOSGi = routines.system.BundleUtils.inOSGi();" + NL + "" + NL + "\tfinal java.util.List<org.apache.cxf.feature.Feature> features_";
  protected final String TEXT_28 = " =" + NL + "\t\t\tnew java.util.ArrayList<org.apache.cxf.feature.Feature>();" + NL + "" + NL + "\t";
  protected final String TEXT_29 = NL + "\t\tfactoryBean_";
  protected final String TEXT_30 = ".setAddress(\"locator://rest\");" + NL + "\t\tfactoryBean_";
  protected final String TEXT_31 = ".setServiceName(new javax.xml.namespace.QName(" + NL + "\t\t\t";
  protected final String TEXT_32 = "," + NL + "\t\t\t";
  protected final String TEXT_33 = "));" + NL + "" + NL + "\t\torg.talend.esb.servicelocator.cxf.LocatorFeature feature_";
  protected final String TEXT_34 = " = null;" + NL + "\t\t" + NL + "\t\tif(!inOSGi){" + NL + "\t    \tfeature_";
  protected final String TEXT_35 = " = (org.talend.esb.servicelocator.cxf.LocatorFeature) new org.springframework.context.support.ClassPathXmlApplicationContext(new String[] { \"META-INF/tesb/locator/beans.xml\" }).getBean(org.talend.esb.servicelocator.cxf.LocatorFeature.class);" + NL + "        }else{" + NL + "        \tfeature_";
  protected final String TEXT_36 = " = routines.system.BundleUtils.getService(org.talend.esb.servicelocator.cxf.LocatorFeature.class);" + NL + "        }" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_37 = NL + "\t\t\tjava.util.Map<String, String> slCustomProps_";
  protected final String TEXT_38 = " = new java.util.HashMap<String, String>();" + NL + "\t\t\tif(factoryBean_";
  protected final String TEXT_39 = ".getProperties() == null){" + NL + "\t\t\t\tfactoryBean_";
  protected final String TEXT_40 = ".setProperties(new java.util.HashMap<String, Object>());" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_41 = NL + "\t\t\t\t\tslCustomProps_";
  protected final String TEXT_42 = ".put(";
  protected final String TEXT_43 = ", ";
  protected final String TEXT_44 = ");" + NL + "\t\t\t";
  protected final String TEXT_45 = NL + NL + "\t\t\tfactoryBean_";
  protected final String TEXT_46 = ".getProperties().put(org.talend.esb.servicelocator.cxf.LocatorFeature.LOCATOR_PROPERTIES,slCustomProps_";
  protected final String TEXT_47 = ");" + NL + "\t\t";
  protected final String TEXT_48 = NL + NL + "\t\tfeatures_";
  protected final String TEXT_49 = ".add(feature_";
  protected final String TEXT_50 = ");" + NL + "\t";
  protected final String TEXT_51 = NL + "\t\tString url = ";
  protected final String TEXT_52 = ";" + NL + "\t\t// {baseUri}tRESTClient" + NL + "\t\tfactoryBean_";
  protected final String TEXT_53 = ".setServiceName(new javax.xml.namespace.QName(url, \"tRESTClient\"));" + NL + "\t\tfactoryBean_";
  protected final String TEXT_54 = ".setAddress(url);" + NL + "\t";
  protected final String TEXT_55 = NL + NL + "\t";
  protected final String TEXT_56 = NL + "\t\torg.talend.esb.sam.agent.feature.EventFeature samEventFeature_";
  protected final String TEXT_57 = " = null;" + NL + "" + NL + "\t\tif(!inOSGi){" + NL + "\t\t\tsamEventFeature_";
  protected final String TEXT_58 = " = (org.talend.esb.sam.agent.feature.EventFeature) new org.springframework.context.support.ClassPathXmlApplicationContext(" + NL + "\t\t\t\t\tnew String[] { \"META-INF/tesb/agent-context.xml\" }).getBean(org.talend.esb.sam.agent.feature.EventFeature.class);" + NL + "\t\t}else{" + NL + "\t\t\tsamEventFeature_";
  protected final String TEXT_59 = " = routines.system.BundleUtils.getService(org.talend.esb.sam.agent.feature.EventFeature.class);" + NL + "\t\t}" + NL + "" + NL + "\t\t";
  protected final String TEXT_60 = NL + "\t\t\tjava.util.Map<String, String> samCustomProps_";
  protected final String TEXT_61 = " = new java.util.HashMap<String, String>();" + NL + "\t\t\t";
  protected final String TEXT_62 = NL + "\t\t\t\tsamCustomProps_";
  protected final String TEXT_63 = NL + "\t\t\t" + NL + "\t\t\tif(factoryBean_";
  protected final String TEXT_64 = ".setProperties(new java.util.HashMap<String,Object>());" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tfactoryBean_";
  protected final String TEXT_65 = ".getProperties().put(org.talend.esb.sam.agent.feature.EventFeature.SAM_PROPERTIES, samCustomProps_";
  protected final String TEXT_66 = NL + "\t\tfeatures_";
  protected final String TEXT_67 = ".add(samEventFeature_";
  protected final String TEXT_68 = ".add(new org.apache.cxf.feature.LoggingFeature());" + NL + "\t";
  protected final String TEXT_69 = NL + "\t\tclass EsbJobCorrelationCallbackHandler implements org.talend.esb.policy.correlation.CorrelationIDCallbackHandler {" + NL + "\t\t\t\tprivate String correlationId;" + NL + "\t\t\t\tpublic EsbJobCorrelationCallbackHandler(final String correlationId) {" + NL + "\t\t\t\t\tif (null != correlationId && correlationId.length() > 0) {" + NL + "\t\t\t\t\t\tthis.correlationId = correlationId;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic String getCorrelationId() {" + NL + "\t\t\t\t\treturn correlationId;" + NL + "\t\t\t\t};" + NL + "\t\t\t}" + NL + "\t\tfinal Object correlationIDCallbackHandler = new EsbJobCorrelationCallbackHandler(";
  protected final String TEXT_70 = ");" + NL + "\t\tfactoryBean_";
  protected final String TEXT_71 = ".getProperties(true).put(" + NL + "\t\t\t\torg.talend.esb.policy.correlation.feature.CorrelationIDFeature.CORRELATION_ID_CALLBACK_HANDLER," + NL + "\t\t\t\tcorrelationIDCallbackHandler);" + NL + "\t\tfeatures_";
  protected final String TEXT_72 = ".add(new org.talend.esb.policy.correlation.feature.CorrelationIDFeature());" + NL + "\t";
  protected final String TEXT_73 = NL + NL + "\tfactoryBean_";
  protected final String TEXT_74 = ".setFeatures(features_";
  protected final String TEXT_75 = ");" + NL + "" + NL + "" + NL + "\tjava.util.List<Object> providers_";
  protected final String TEXT_76 = " = new java.util.ArrayList<Object>();" + NL + "\tproviders_";
  protected final String TEXT_77 = ".add(new org.apache.cxf.jaxrs.provider.dom4j.DOM4JProvider() {" + NL + "\t\t// workaround for https://jira.talendforge.org/browse/TESB-7276" + NL + "\t\tpublic org.dom4j.Document readFrom(Class<org.dom4j.Document> cls," + NL + "\t\t\t\t\t\t\t\t\t\t\tjava.lang.reflect.Type type," + NL + "\t\t\t\t\t\t\t\t\t\t\tjava.lang.annotation.Annotation[] anns," + NL + "\t\t\t\t\t\t\t\t\t\t\tjavax.ws.rs.core.MediaType mt," + NL + "\t\t\t\t\t\t\t\t\t\t\tjavax.ws.rs.core.MultivaluedMap<String, String> headers," + NL + "\t\t\t\t\t\t\t\t\t\t\tjava.io.InputStream is)" + NL + "\t\t\t\tthrows IOException, javax.ws.rs.WebApplicationException {" + NL + "\t\t\tString contentLength = headers.getFirst(\"Content-Length\");" + NL + "\t\t\tif (!org.apache.cxf.common.util.StringUtils.isEmpty(contentLength)" + NL + "\t\t\t\t\t&& Integer.valueOf(contentLength) <= 0) {" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\treturn org.dom4j.DocumentHelper.parseText(\"<root/>\");" + NL + "\t\t\t\t} catch (org.dom4j.DocumentException e_";
  protected final String TEXT_78 = ") {" + NL + "\t\t\t\t\te_";
  protected final String TEXT_79 = ".printStackTrace();" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\treturn super.readFrom(cls, type, anns, mt, headers, is);" + NL + "\t\t}" + NL + "\t});" + NL + "\torg.apache.cxf.jaxrs.provider.json.JSONProvider jsonProvider_";
  protected final String TEXT_80 = " =" + NL + "\t\t\tnew org.apache.cxf.jaxrs.provider.json.JSONProvider();" + NL + "\t\tjsonProvider_";
  protected final String TEXT_81 = ".setIgnoreNamespaces(true);" + NL + "\t\tjsonProvider_";
  protected final String TEXT_82 = ".setAttributesToElements(true);" + NL + "\t";
  protected final String TEXT_83 = NL + "\t";
  protected final String TEXT_84 = NL + "\t\tjsonProvider_";
  protected final String TEXT_85 = ".setSupportUnwrapped(true);" + NL + "\t\tjsonProvider_";
  protected final String TEXT_86 = ".setWrapperName(\"root\");" + NL + "\t";
  protected final String TEXT_87 = ".setDropRootElement(";
  protected final String TEXT_88 = ");" + NL + "\t\tjsonProvider_";
  protected final String TEXT_89 = ".setConvertTypesToStrings(";
  protected final String TEXT_90 = ");" + NL + "\tproviders_";
  protected final String TEXT_91 = ".add(jsonProvider_";
  protected final String TEXT_92 = ");" + NL + "\tfactoryBean_";
  protected final String TEXT_93 = ".setProviders(providers_";
  protected final String TEXT_94 = ".setTransportId(\"http://cxf.apache.org/transports/http\");" + NL + "" + NL + "\tboolean use_auth_";
  protected final String TEXT_95 = ";" + NL + "\t" + NL + "\t";
  protected final String TEXT_96 = NL + "\t\tif (use_auth_";
  protected final String TEXT_97 = " && \"SAML\".equals(";
  protected final String TEXT_98 = ")) {" + NL + "\t\t\tif (!inOSGi) {" + NL + "\t\t\t\tthrow new IllegalArgumentException(\"SAML based security scenarios are not supported in Studio (standalone)\");" + NL + "\t\t\t}" + NL + "\t\t\t// set SAML Token authentication" + NL + "\t\t\t";
  protected final String TEXT_99 = NL + "\t\t\t";
  protected final String TEXT_100 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_101 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_102 = ");";
  protected final String TEXT_103 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_104 = "; ";
  protected final String TEXT_105 = NL + "\t" + NL + "\t\t\torg.apache.cxf.ws.security.trust.STSClient stsClient =" + NL + "\t\t\t\torg.talend.esb.security.saml.STSClientUtils.createSTSClient(factoryBean_";
  protected final String TEXT_106 = ".getBus()," + NL + "\t\t\t\t\t";
  protected final String TEXT_107 = ", decryptedPassword_";
  protected final String TEXT_108 = NL + "\t\t\t\torg.talend.esb.security.saml.STSClientUtils.applyAuthorization(stsClient, ";
  protected final String TEXT_109 = NL + "\t\t\torg.talend.esb.security.saml.SAMLRESTUtils.configureClient(factoryBean_";
  protected final String TEXT_110 = ", stsClient);" + NL + "\t\t}" + NL + "" + NL + "\t";
  protected final String TEXT_111 = NL + NL + "\torg.apache.cxf.jaxrs.client.WebClient webClient_";
  protected final String TEXT_112 = " = factoryBean_";
  protected final String TEXT_113 = ".createWebClient();" + NL + "" + NL + "\t// set request path" + NL + "\twebClient_";
  protected final String TEXT_114 = ".path(";
  protected final String TEXT_115 = ");" + NL + "" + NL + "\t// set connection properties" + NL + "\torg.apache.cxf.jaxrs.client.ClientConfiguration clientConfig_";
  protected final String TEXT_116 = " = org.apache.cxf.jaxrs.client.WebClient.getConfig(webClient_";
  protected final String TEXT_117 = ");" + NL + "\torg.apache.cxf.transport.http.HTTPConduit conduit_";
  protected final String TEXT_118 = " = clientConfig_";
  protected final String TEXT_119 = ".getHttpConduit();" + NL + "" + NL + "    if (clientConfig_";
  protected final String TEXT_120 = ".getEndpoint() != null" + NL + "            && clientConfig_";
  protected final String TEXT_121 = ".getEndpoint().getEndpointInfo() != null) {" + NL + "        clientConfig_";
  protected final String TEXT_122 = ".getEndpoint().getEndpointInfo().setProperty(\"enable.webclient.operation.reporting\",";
  protected final String TEXT_123 = NL + "                                                                          ";
  protected final String TEXT_124 = ");" + NL + "    }" + NL + "" + NL + "\t";
  protected final String TEXT_125 = NL + NL + "        org.apache.cxf.configuration.jsse.TLSClientParameters tlsClientParameters_";
  protected final String TEXT_126 = " = new org.apache.cxf.configuration.jsse.TLSClientParameters();" + NL + "        tlsClientParameters_";
  protected final String TEXT_127 = ".setDisableCNCheck(true);" + NL + "        conduit_";
  protected final String TEXT_128 = ".setTlsClientParameters(tlsClientParameters_";
  protected final String TEXT_129 = ");" + NL + "" + NL + "\t";
  protected final String TEXT_130 = NL + "\t" + NL + "\t\t\tif (use_auth_";
  protected final String TEXT_131 = " && \"BASIC\".equals(";
  protected final String TEXT_132 = ")) {" + NL + "\t\t\t// set BASIC auth" + NL + "\t\t\t";
  protected final String TEXT_133 = NL + "\t" + NL + "\t\t\torg.apache.cxf.configuration.security.AuthorizationPolicy authPolicy_";
  protected final String TEXT_134 = " = new org.apache.cxf.configuration.security.AuthorizationPolicy();" + NL + "\t\t\t\tauthPolicy_";
  protected final String TEXT_135 = ".setAuthorizationType(\"Basic\");" + NL + "\t\t\t\tauthPolicy_";
  protected final String TEXT_136 = ".setUserName(";
  protected final String TEXT_137 = ");" + NL + "\t\t\t\tauthPolicy_";
  protected final String TEXT_138 = ".setPassword(decryptedPassword_";
  protected final String TEXT_139 = ");" + NL + "\t\t\tconduit_";
  protected final String TEXT_140 = ".setAuthorization(authPolicy_";
  protected final String TEXT_141 = ");" + NL + "\t\t} else if (use_auth_";
  protected final String TEXT_142 = " && \"HTTP Digest\".equals(";
  protected final String TEXT_143 = ")) {" + NL + "\t\t\t// set Digest auth" + NL + "\t\t\t";
  protected final String TEXT_144 = " = new org.apache.cxf.configuration.security.AuthorizationPolicy();" + NL + "\t\t\tauthPolicy_";
  protected final String TEXT_145 = ".setAuthorizationType(\"Digest\");" + NL + "\t\t\tauthPolicy_";
  protected final String TEXT_146 = ");" + NL + "\t\t\tauthPolicy_";
  protected final String TEXT_147 = ");" + NL + "\t\t}" + NL + "\t" + NL + "\t";
  protected final String TEXT_148 = NL + NL + "\tif (!inOSGi) {" + NL + "\t\tconduit_";
  protected final String TEXT_149 = ".getClient().setReceiveTimeout((long)(";
  protected final String TEXT_150 = " * 1000L));" + NL + "\t\tconduit_";
  protected final String TEXT_151 = ".getClient().setConnectionTimeout((long)(";
  protected final String TEXT_152 = " * 1000L));" + NL + "\t\tboolean use_proxy_";
  protected final String TEXT_153 = ";" + NL + "\t\t";
  protected final String TEXT_154 = NL + "\t\t\tif (use_proxy_";
  protected final String TEXT_155 = ") {" + NL + "\t\t\t\t";
  protected final String TEXT_156 = NL + "\t\t\t\t";
  protected final String TEXT_157 = NL + "\t" + NL + "\t\t\t\tconduit_";
  protected final String TEXT_158 = ".getClient().setProxyServer(";
  protected final String TEXT_159 = ");" + NL + "\t\t\t\tconduit_";
  protected final String TEXT_160 = ".getClient().setProxyServerPort(Integer.valueOf(";
  protected final String TEXT_161 = "));" + NL + "\t\t\t\tconduit_";
  protected final String TEXT_162 = ".getProxyAuthorization().setUserName(";
  protected final String TEXT_163 = ".getProxyAuthorization().setPassword(decryptedPassword_";
  protected final String TEXT_164 = ");" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_165 = NL + "\t}" + NL + "\t";
  protected final String TEXT_166 = NL + "\t        org.apache.cxf.configuration.jsse.TLSClientParameters clientParameters = new org.apache.cxf.configuration.jsse.TLSClientParameters();" + NL + "\t        clientParameters.setUseHttpsURLConnectionDefaultHostnameVerifier(true);" + NL + "\t        conduit_";
  protected final String TEXT_167 = ".setTlsClientParameters(clientParameters);" + NL + "\t";
  protected final String TEXT_168 = NL + "\t\tconduit_";
  protected final String TEXT_169 = ".getClient().setAutoRedirect(true);" + NL + "\t\tclientConfig_";
  protected final String TEXT_170 = ".getRequestContext().put(\"http.redirect.relative.uri\", true);" + NL + "\t\tclientConfig_";
  protected final String TEXT_171 = ".getRequestContext().put(\"http.redirect.same.host.only\", ";
  protected final String TEXT_172 = ".getClient().setAllowChunking(false);" + NL + "\t";
  protected final String TEXT_173 = NL + "\t\t// set Content-Type" + NL + "\t\twebClient_";
  protected final String TEXT_174 = ".type(\"";
  protected final String TEXT_175 = "\");" + NL + "\t";
  protected final String TEXT_176 = NL + "\t\t// set Accept-Type" + NL + "\t\twebClient_";
  protected final String TEXT_177 = ".accept(\"";
  protected final String TEXT_178 = NL + "\t\t// set optional query and header properties if any" + NL + "\t";
  protected final String TEXT_179 = NL + "\t\twebClient_";
  protected final String TEXT_180 = ".header(";
  protected final String TEXT_181 = NL + "\tif (use_auth_";
  protected final String TEXT_182 = " && \"OAUTH2_BEARER\".equals(";
  protected final String TEXT_183 = ")) {" + NL + "\t\t// set oAuth2 bearer token" + NL + "\t\twebClient_";
  protected final String TEXT_184 = ".header(\"Authorization\", \"Bearer \" + ";
  protected final String TEXT_185 = ");" + NL + "\t}" + NL + "\t" + NL + "\t";
  protected final String TEXT_186 = NL + "\t" + NL + "\t\tif (use_auth_";
  protected final String TEXT_187 = " && \"OIDC_PASSWORD_GRANT\".equals(";
  protected final String TEXT_188 = ")) {" + NL + "\t" + NL + "\t        ";
  protected final String TEXT_189 = NL + "\t        ";
  protected final String TEXT_190 = NL + "\t" + NL + "\t        String username_";
  protected final String TEXT_191 = ";" + NL + "\t        String password_";
  protected final String TEXT_192 = " = decryptedPassword_";
  protected final String TEXT_193 = ";" + NL + "\t" + NL + "\t        String bearerHeader_";
  protected final String TEXT_194 = " = null;" + NL + "\t" + NL + "\t        try {" + NL + "\t\t\t\tif (!inOSGi) {" + NL + "\t\t\t\t\torg.springframework.context.support.ClassPathXmlApplicationContext context_";
  protected final String TEXT_195 = " =" + NL + "\t\t\t\t\t\tnew org.springframework.context.support.ClassPathXmlApplicationContext(\"META-INF/tesb/oidc-context.xml\");" + NL + "\t\t\t\t\torg.talend.esb.security.oidc.OidcConfiguration oidcConfiguration_";
  protected final String TEXT_196 = " = context_";
  protected final String TEXT_197 = ".getBean(org.talend.esb.security.oidc.OidcConfiguration.class);" + NL + "\t\t\t\t\tbearerHeader_";
  protected final String TEXT_198 = " = org.talend.esb.security.oidc.OidcClientUtils.oidcClientBearer(username_";
  protected final String TEXT_199 = ", password_";
  protected final String TEXT_200 = ", oidcConfiguration_";
  protected final String TEXT_201 = ");" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\tbearerHeader_";
  protected final String TEXT_202 = ");" + NL + "\t\t\t\t}" + NL + "\t\t\t} catch (Exception ex) {" + NL + "\t            throw new javax.ws.rs.WebApplicationException(\"Failed to get OIDC access token: \", ex);" + NL + "\t        }" + NL + "\t" + NL + "\t\t\twebClient_";
  protected final String TEXT_203 = ".header(\"Authorization\", bearerHeader_";
  protected final String TEXT_204 = NL + "    " + NL + "\t// if FORM request then capture query parameters into Form, otherwise set them as queries" + NL + "\t";
  protected final String TEXT_205 = NL + "\t\tjavax.ws.rs.core.Form form_";
  protected final String TEXT_206 = " = new javax.ws.rs.core.Form();" + NL + "\t\t";
  protected final String TEXT_207 = NL + "\t\t\tform_";
  protected final String TEXT_208 = ".param(";
  protected final String TEXT_209 = " ,";
  protected final String TEXT_210 = NL + "\t\trequestBody_";
  protected final String TEXT_211 = " = form_";
  protected final String TEXT_212 = ";" + NL + "\t";
  protected final String TEXT_213 = NL + "\t\t";
  protected final String TEXT_214 = NL + "\t\t\twebClient_";
  protected final String TEXT_215 = ".query(";
  protected final String TEXT_216 = NL + NL + NL + "\ttry {" + NL + "\t\t// start send request" + NL + "\t\t";
  protected final String TEXT_217 = NL + "\t\t\tresponseDoc_";
  protected final String TEXT_218 = " = webClient_";
  protected final String TEXT_219 = ".get";
  protected final String TEXT_220 = "Collection";
  protected final String TEXT_221 = "(responseClass_";
  protected final String TEXT_222 = NL + "\t\t\t\tresponseDoc_";
  protected final String TEXT_223 = ".postObjectGetCollection(requestBody_";
  protected final String TEXT_224 = ", responseClass_";
  protected final String TEXT_225 = ".post(requestBody_";
  protected final String TEXT_226 = ".put(requestBody_";
  protected final String TEXT_227 = NL + "\t\t\torg.apache.cxf.jaxrs.client.WebClient.getConfig(webClient_";
  protected final String TEXT_228 = ").getRequestContext().put(\"use.httpurlconnection.method.reflection\", true);" + NL + "\t\t\tresponseDoc_";
  protected final String TEXT_229 = ".invoke(\"PATCH\", requestBody_";
  protected final String TEXT_230 = NL + "\t\t    responseDoc_";
  protected final String TEXT_231 = ".invoke(\"";
  protected final String TEXT_232 = "\", requestBody_";
  protected final String TEXT_233 = NL + NL + NL + "\t\tint webClientResponseStatus_";
  protected final String TEXT_234 = ".getResponse().getStatus();" + NL + "\t\tif (webClientResponseStatus_";
  protected final String TEXT_235 = " >= 300) {" + NL + "\t\t\tthrow new javax.ws.rs.WebApplicationException(webClient_";
  protected final String TEXT_236 = ".getResponse());" + NL + "\t\t}" + NL + "" + NL + "\t\t";
  protected final String TEXT_237 = NL + "\t\t\tif (";
  protected final String TEXT_238 = " == null) {" + NL + "\t\t\t\t";
  protected final String TEXT_239 = " = new ";
  protected final String TEXT_240 = "Struct();" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_241 = ".statusCode = webClientResponseStatus_";
  protected final String TEXT_242 = ";" + NL + "\t\t\t";
  protected final String TEXT_243 = NL + "\t\t\t\t{" + NL + "\t\t\t\t\tObject responseObj_";
  protected final String TEXT_244 = " = responseDoc_";
  protected final String TEXT_245 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_246 = NL + "\t\t\t\tObject responseObj_";
  protected final String TEXT_247 = " = null;" + NL + "\t\t\t\tif(responseDoc_";
  protected final String TEXT_248 = " != null && responseDoc_";
  protected final String TEXT_249 = ".hasEntity()){" + NL + "\t\t\t\t\tresponseObj_";
  protected final String TEXT_250 = ".readEntity(responseClass_";
  protected final String TEXT_251 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_252 = NL + "\t\t\t\tif(responseObj_";
  protected final String TEXT_253 = " != null){" + NL + "\t\t\t\t\tif (responseClass_";
  protected final String TEXT_254 = " == String.class) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_255 = ".string = (String) responseObj_";
  protected final String TEXT_256 = ";" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\troutines.system.Document responseTalendDoc_";
  protected final String TEXT_257 = " = null;" + NL + "\t\t\t\t\t\tif (null != responseObj_";
  protected final String TEXT_258 = ") {" + NL + "\t\t\t\t\t\t\tresponseTalendDoc_";
  protected final String TEXT_259 = " = new routines.system.Document();" + NL + "\t\t\t\t\t\t\tresponseTalendDoc_";
  protected final String TEXT_260 = ".setDocument((org.dom4j.Document) responseObj_";
  protected final String TEXT_261 = ");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_262 = ".body = responseTalendDoc_";
  protected final String TEXT_263 = ";" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_264 = NL + NL + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_265 = "_HEADERS\", webClient_";
  protected final String TEXT_266 = ".getResponse().getHeaders());" + NL + "\t\t\t";
  protected final String TEXT_267 = NL + "\t\t\tif (null != webClient_";
  protected final String TEXT_268 = ".getResponse().getHeaders().get(\"CorrelationID\")) {" + NL + "\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_269 = "_CORRELATION_ID\", webClient_";
  protected final String TEXT_270 = ".getResponse().getHeaders().get(\"CorrelationID\").get(0));" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_271 = NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_272 = NL + "\t\t\t// handle \"oneway\" for PUT, POST and PATCH with empty response payload" + NL + "\t\t\tif (webClientResponseStatus_";
  protected final String TEXT_273 = " == 202 && responseObj_";
  protected final String TEXT_274 = " == null){" + NL + "\t\t\t\t";
  protected final String TEXT_275 = ".string = \"\";" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_276 = NL + NL + "\t} catch (javax.ws.rs.WebApplicationException ex_";
  protected final String TEXT_277 = ") {" + NL + "\t\t";
  protected final String TEXT_278 = "Struct();" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_279 = ".errorCode = ex_";
  protected final String TEXT_280 = ".getResponse().getStatus();" + NL + "" + NL + "\t\t\tString errorMessage_";
  protected final String TEXT_281 = " = null;" + NL + "\t\t\ttry {" + NL + "\t\t\t\terrorMessage_";
  protected final String TEXT_282 = " = ex_";
  protected final String TEXT_283 = ".getResponse().readEntity(String.class);" + NL + "\t\t\t} catch (Exception exe_";
  protected final String TEXT_284 = ") {" + NL + "\t\t\t\t// ignore" + NL + "\t\t\t}" + NL + "\t\t\tif (null == errorMessage_";
  protected final String TEXT_285 = " || 0 == errorMessage_";
  protected final String TEXT_286 = ".trim().length()) {" + NL + "\t\t\t\terrorMessage_";
  protected final String TEXT_287 = ".getMessage();" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_288 = ".errorMessage = errorMessage_";
  protected final String TEXT_289 = ";" + NL + "" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_290 = "_HEADERS\", ex_";
  protected final String TEXT_291 = NL + "\t\t\tthrow ex_";
  protected final String TEXT_292 = NL + "\t}" + NL + "" + NL + "} catch(Exception e_";
  protected final String TEXT_293 = ") {" + NL + "\t";
  protected final String TEXT_294 = NL + "\t\tthrow new TalendException(e_";
  protected final String TEXT_295 = ", currentComponent, globalMap);" + NL + "\t";
  protected final String TEXT_296 = NL + "\t\tnew TalendException(e_";
  protected final String TEXT_297 = ", currentComponent, globalMap).printStackTrace();" + NL + "\t";
  protected final String TEXT_298 = NL + "}" + NL;
  protected final String TEXT_299 = NL + "java.util.Collection<String> responseParts_";
  protected final String TEXT_300 = " = new java.util.ArrayList<String>();";
  protected final String TEXT_301 = NL + "org.apache.cxf.jaxrs.ext.multipart.MultipartBody multipartBody_";
  protected final String TEXT_302 = " =responseDoc_";
  protected final String TEXT_303 = ".readEntity(org.apache.cxf.jaxrs.ext.multipart.MultipartBody.class);" + NL + "try {" + NL + "\tfor (org.apache.cxf.jaxrs.ext.multipart.Attachment att_";
  protected final String TEXT_304 = " : multipartBody_";
  protected final String TEXT_305 = ".getAllAttachments()) {" + NL + "       java.io.InputStream is_";
  protected final String TEXT_306 = " = att_";
  protected final String TEXT_307 = ".getDataHandler().getInputStream();" + NL + "       java.util.Scanner s_";
  protected final String TEXT_308 = " = new java.util.Scanner(is_";
  protected final String TEXT_309 = ").useDelimiter(\"\\\\A\");" + NL + "       responseParts_";
  protected final String TEXT_310 = ".add(s_";
  protected final String TEXT_311 = ".hasNext() ? s_";
  protected final String TEXT_312 = ".next() : \"\");" + NL + "       is_";
  protected final String TEXT_313 = ".close();" + NL + "   }" + NL + "} catch (java.io.IOException e_";
  protected final String TEXT_314 = NL + "}";
  protected final String TEXT_315 = NL + "for (String responsePart_";
  protected final String TEXT_316 = " : responseDoc_";
  protected final String TEXT_317 = ") {" + NL + "    responseParts_";
  protected final String TEXT_318 = ".add(responsePart_";
  protected final String TEXT_319 = ");" + NL + "}";
  protected final String TEXT_320 = " : responseParts_";
  protected final String TEXT_321 = ") {" + NL + "    row1 = new row1Struct();" + NL + "    row1.string = responsePart_";
  protected final String TEXT_322 = ";";
  protected final String TEXT_323 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode) codeGenArgument.getArgument();

final String MULTIPART_MIXED = "multipart/mixed";

/*INIT PARAMETERS AND INDICATORS.*/
NodeConnectionsHelper connsHelper = new NodeConnectionsHelper(node);
IConnection inputConn = connsHelper.getInputConn();
IConnection connResponse = connsHelper.getOutputConnResponse();
IConnection connFault = connsHelper.getOutputConnFault();
List<IConnection> dataOutputs = connsHelper.getDataOutputs();

String cid = node.getUniqueName();
String passwordFieldName;
NodeParamsHelper paramsHelper = new NodeParamsHelper(node);

String method = paramsHelper.getStringParam("__METHOD__");
String acceptType = paramsHelper.getStringParam("__ACCEPT_TYPE__");
if (acceptType == null) {
	acceptType = "application/xml";
}
String contentType = paramsHelper.getStringParam("__CONTENT_TYPE__");
if (contentType == null) {
	contentType = "application/xml";
}

String useAuth = ElementParameterParser.getValue(node, "__NEED_AUTH__");
if (!node.getElementParameter("NEED_AUTH").isContextMode()) {
	// non-dynamic (bug with non updating parameter value after removing field from dynamic)
	useAuth = "true".equals(useAuth) ? "true" : "false";
}
String authType = paramsHelper.getStringParam("__AUTH_TYPE__");
if (!node.getElementParameter("AUTH_TYPE").isContextMode()) {
	authType = "\"" + authType + "\"";
}

String useProxy = ElementParameterParser.getValue(node, "__USE_PROXY__");
if (!node.getElementParameter("USE_PROXY").isContextMode()) {
	// non-dynamic (bug with non updating parameter value after removing field from dynamic)
	useProxy = "true".equals(useProxy) ? "true" : "false";
}

boolean isSLEnable = paramsHelper.getBoolParam("__SERVICE_LOCATOR__");
boolean isSAMEnable = paramsHelper.getBoolParam("__SERVICE_ACTIVITY_MONITOR__");
boolean useBusinessCorrelation = paramsHelper.getBoolParam("__USE_BUSINESS_CORRELATION__");

/*GENERATE CODE*/
//clear connection row data
for (IConnection conn : dataOutputs) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_2);
    
}

    stringBuffer.append(TEXT_3);
     if (MULTIPART_MIXED.equals(acceptType)) {
       if ("PUT".equals(method) || "PATCH".equals(method)) {
           
    stringBuffer.append(TEXT_4);
    
       } else {
           
    stringBuffer.append(TEXT_5);
    
       }
} else { 
       if ("GET".equals(method)) {
           
    stringBuffer.append(TEXT_6);
    
       }else {
           
    stringBuffer.append(TEXT_4);
     
       }  
}
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    	if (null != inputConn) {
		IMetadataColumn inputConnBodyColumn = inputConn.getMetadataTable().getColumn("body");
		if (null != inputConnBodyColumn && "id_Document".equals(inputConnBodyColumn.getTalendType())) { 
    stringBuffer.append(TEXT_10);
    stringBuffer.append(inputConn.getName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(inputConn.getName());
    stringBuffer.append(TEXT_13);
    		}
		IMetadataColumn inputConnStringColumn = inputConn.getMetadataTable().getColumn("string");
		if (null != inputConnStringColumn && "id_String".equals(inputConnStringColumn.getTalendType())) { 
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(inputConn.getName());
    stringBuffer.append(TEXT_15);
    		}
	} 
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    
		String convertResponseToDomProperty = paramsHelper.getStringParam("__CONVERT_RESPONSE_TO_DOM__");
		boolean convertResponseToDom = convertResponseToDomProperty == null ? true : Boolean.valueOf(convertResponseToDomProperty);
	
    stringBuffer.append(TEXT_21);
    
    String responseClassName = null;
    if ("*/*".equals(acceptType) || !convertResponseToDom) {
        responseClassName = "String";
    } else if  (MULTIPART_MIXED.equals(acceptType)) {
        if ("PUT".equals(method) || "PATCH".equals(method)) {
            responseClassName = "javax.ws.rs.core.Response";
        } else {
            responseClassName = "String";
        }
    } else {
        responseClassName = "org.dom4j.Document";
    }

    stringBuffer.append(TEXT_22);
     if (MULTIPART_MIXED.equals(acceptType)) {
    stringBuffer.append(responseClassName);
    } else {
    stringBuffer.append(TEXT_23);
    } 
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(responseClassName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
     if (isSLEnable) { 
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(paramsHelper.getStringParam("__SERVICE_NAMESPACE__"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(paramsHelper.getStringParam("__SERVICE_NAME__"));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
     List<Map<String, String>> customProperties = (List<Map<String,String>>) ElementParameterParser.getObjectValue(node,"__SERVICE_LOCATOR_CUSTOM_PROPERTIES__");
		if (!customProperties.isEmpty()) { 
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
     for (Map<String,String> prop : customProperties) { 
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(prop.get("PROP_NAME"));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(prop.get("PROP_VALUE"));
    stringBuffer.append(TEXT_44);
     } 
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
     } 
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
     } else { 
    stringBuffer.append(TEXT_51);
    stringBuffer.append(paramsHelper.getStringParam("__URL__"));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
     } 
    stringBuffer.append(TEXT_55);
     if (isSAMEnable) { 
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
     List<Entry<String, String>> samCustomProperties = paramsHelper.getPropertiesPram("__SERVICE_ACTIVITY_MONITOR_CUSTOM_PROPERTIES__");
		if (!samCustomProperties.isEmpty()) { 
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
     for (Entry<String,String> prop : samCustomProperties) { 
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(prop.getKey());
    stringBuffer.append(TEXT_43);
    stringBuffer.append(prop.getValue());
    stringBuffer.append(TEXT_44);
     } 
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
     } 
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
     } 
    stringBuffer.append(TEXT_55);
     if (paramsHelper.getBoolParam("__LOG_MESSAGES__")) { 
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
     } 
    stringBuffer.append(TEXT_55);
     if (useBusinessCorrelation) { 
    stringBuffer.append(TEXT_69);
    stringBuffer.append(paramsHelper.getStringParam("__CORRELATION_VALUE__"));
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
     } 
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    
		String wrapJsonResponseProperty = paramsHelper.getStringParam("__WRAP_JSON_RESPONSE__");
		boolean wrapJsonResponse = wrapJsonResponseProperty == null ? true : Boolean.valueOf(wrapJsonResponseProperty);
	
    stringBuffer.append(TEXT_83);
     if (wrapJsonResponse) { 
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
     } 
    stringBuffer.append(TEXT_83);
    
		boolean dropJsonRoot = (("POST".equals(method) || "PUT".equals(method) || "PATCH".equals(method)) && "application/json".equals(contentType))
				? paramsHelper.getBoolParam("__UNWRAP_JSON_REQUEST__") : false;
		boolean convertTypesToStrings  = ("application/json".equals(contentType) || "application/json".equals(acceptType) || "*/*".equals(acceptType) )
				? paramsHelper.getBoolParam("__CONVERT_TYPES_TO_STRINGS__") : false;
	
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(dropJsonRoot);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(convertTypesToStrings);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(useAuth);
    stringBuffer.append(TEXT_95);
     if("true".equals(useAuth)){
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(authType);
    stringBuffer.append(TEXT_98);
     passwordFieldName = "__AUTH_PASSWORD__"; 
    stringBuffer.append(TEXT_99);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_102);
    } else {
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_104);
    }
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(ElementParameterParser.getValue(node, "__AUTH_USERNAME__"));
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
     if ("true".equals(ElementParameterParser.getValue(node, "__NEED_AUTHORIZATION__"))) { 
    stringBuffer.append(TEXT_108);
    stringBuffer.append(ElementParameterParser.getValue(node, "__ROLE__"));
    stringBuffer.append(TEXT_44);
     } 
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    }
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(paramsHelper.getStringParam("__PATH__"));
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(paramsHelper.getStringParam("__ENABLE_WEBCLIENT_OPERATION_REPORTING__"));
    stringBuffer.append(TEXT_124);
     if (!paramsHelper.getBoolParam( "__CHECK_SERVER_IDENTITY__")) { 
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
     } 
    stringBuffer.append(TEXT_55);
     if("true".equals(useAuth)){
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(authType);
    stringBuffer.append(TEXT_132);
     passwordFieldName = "__AUTH_PASSWORD__"; 
    stringBuffer.append(TEXT_99);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_102);
    } else {
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_104);
    }
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(paramsHelper.getStringParam("__AUTH_USERNAME__"));
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(authType);
    stringBuffer.append(TEXT_143);
     passwordFieldName = "__AUTH_PASSWORD__"; 
    stringBuffer.append(TEXT_99);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_102);
    } else {
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_104);
    }
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(paramsHelper.getStringParam("__AUTH_USERNAME__"));
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    }
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(paramsHelper.getStringParam("__RECEIVE_TIMEOUT__"));
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(paramsHelper.getStringParam("__CONNECTION_TIMEOUT__"));
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(useProxy);
    stringBuffer.append(TEXT_153);
     if("true".equals(useProxy)){
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
     passwordFieldName = "__PROXY_PASSWORD__"; 
    stringBuffer.append(TEXT_156);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_102);
    } else {
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_104);
    }
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(paramsHelper.getStringParam("__PROXY_HOST__"));
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(paramsHelper.getStringParam("__PROXY_PORT__"));
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(paramsHelper.getStringParam("__PROXY_USERNAME__"));
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    }
    stringBuffer.append(TEXT_165);
    
	/*tSetKeystore-TESB-22406*/
	if (!node.getProcess().getNodesOfType("tSetKeystore").isEmpty()) {
	    INode keystoreNode = node.getProcess().getNodesOfType("tSetKeystore").get(0);
	    if(("false").equals(ElementParameterParser.getValue(keystoreNode, "__VERIFY_NAME__"))){
	
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    
	    }
	}
	
    stringBuffer.append(TEXT_83);
     if (paramsHelper.getBoolParam("__FOLLOW_REDIRECTS__")) { 
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(!paramsHelper.getBoolParam("__REDIRECT_NON_SAME_HOST__"));
    stringBuffer.append(TEXT_50);
     } 
    stringBuffer.append(TEXT_55);
     if (paramsHelper.getBoolParam("__DISABLE_CHUNKED_ENCODING__")) { 
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
     } 
    stringBuffer.append(TEXT_55);
     if (!"GET".equals(method) && !"DELETE".equals(method)) { 
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(contentType);
    stringBuffer.append(TEXT_175);
     } 
    stringBuffer.append(TEXT_55);
     if (!acceptType.isEmpty()) { 
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(acceptType);
    stringBuffer.append(TEXT_175);
     } 
    stringBuffer.append(TEXT_55);
     List<Map<String, String>> headers = paramsHelper.getObjectParam("__HEADERS__"); 
    stringBuffer.append(TEXT_178);
     for (Map<String, String> header : headers) { 
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(header.get("NAME"));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(header.get("VALUE"));
    stringBuffer.append(TEXT_50);
     } 
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(authType);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(paramsHelper.getStringParam("__AUTH_BEARER_TOKEN__"));
    stringBuffer.append(TEXT_185);
    if("true".equals(useAuth)){
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(authType);
    stringBuffer.append(TEXT_188);
     passwordFieldName = "__AUTH_PASSWORD__"; 
    stringBuffer.append(TEXT_189);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_102);
    } else {
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_104);
    }
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(paramsHelper.getStringParam("__AUTH_USERNAME__"));
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    }
    stringBuffer.append(TEXT_204);
     List<Map<String, String>> queries = paramsHelper.getObjectParam("__QUERY__");
		if ("application/x-www-form-urlencoded".equals(contentType) && !"GET".equals(method) && !"DELETE".equals(method)) { 
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
     for (Map<String, String> query : queries) { 
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(query.get("NAME"));
    stringBuffer.append(TEXT_209);
    stringBuffer.append(query.get("VALUE"));
    stringBuffer.append(TEXT_47);
     } 
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
     } else { 
    stringBuffer.append(TEXT_213);
     for (Map<String, String> query : queries) { 
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(query.get("NAME"));
    stringBuffer.append(TEXT_209);
    stringBuffer.append(query.get("VALUE"));
    stringBuffer.append(TEXT_47);
     } 
    stringBuffer.append(TEXT_83);
     } 
    stringBuffer.append(TEXT_216);
     if ("GET".equals(method)) { 
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    if (MULTIPART_MIXED.equals(acceptType)) {
    stringBuffer.append(TEXT_220);
    }
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
     } else if ("POST".equals(method)) { 
    stringBuffer.append(TEXT_99);
    if (MULTIPART_MIXED.equals(acceptType)) { 
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
     } else { 
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
     } 
    stringBuffer.append(TEXT_213);
     } else if ("PUT".equals(method)) { 
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
     } else if ("PATCH".equals(method)) { 
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
     } else if ("DELETE".equals(method)) { 
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
     } else { 
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
     } 
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
     if (null != connResponse) {
			String connResponseName = connResponse.getName(); 
    stringBuffer.append(TEXT_237);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
     if (!MULTIPART_MIXED.equals(acceptType)) {
    stringBuffer.append(TEXT_156);
     if ("GET".equals(method)) {
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    } else {
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    }
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
     } 
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
     if (useBusinessCorrelation) { 
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
     } 
    stringBuffer.append(TEXT_271);
     if (!MULTIPART_MIXED.equals(acceptType) && !"GET".equals(method)) { 
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_275);
     } 
    stringBuffer.append(TEXT_213);
     } 
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
     if (null != connFault) {
			String connFaultName = connFault.getName(); 
    stringBuffer.append(TEXT_237);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
     if (useBusinessCorrelation) { 
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
     } 
    stringBuffer.append(TEXT_213);
     } else { 
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
     } 
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
     if (paramsHelper.getBoolParam( "__DIE_ON_ERROR__")) { 
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
     } else { 
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
     } 
    stringBuffer.append(TEXT_298);
     if (MULTIPART_MIXED.equals(acceptType)) {
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    
     if ("PUT".equals(method) || "PATCH".equals(method)) {
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
     if (paramsHelper.getBoolParam( "__DIE_ON_ERROR__")) { 
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
     } else { 
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
     } 
    stringBuffer.append(TEXT_314);
     } else { 
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_319);
     } 
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
     } 
    stringBuffer.append(TEXT_323);
    return stringBuffer.toString();
  }
}
