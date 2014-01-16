<?xml version="1.0" encoding="UTF-8" ?>
<?oracle-xsl-mapper
  <!-- SPECIFICATION OF MAP SOURCES AND TARGETS, DO NOT MODIFY. -->
  <mapSources>
    <source type="WSDL">
      <schema location="../OrNOCGetDiagnostiDAC.wsdl"/>
      <rootElement name="process" namespace="http://xmlns.cablevision.net.mx/DrCable_SOA/DrCable/OrNOCGetDiagnostiDAC"/>
    </source>
    <source type="WSDL">
      <schema location="../VitriaDAC_initial_InvocaDAC.wsdl"/>
      <rootElement name="invokerResponse" namespace="http://dacInvoker.vitria.cablevision.com"/>
      <param name="outputDAC.parameters" />
    </source>
  </mapSources>
  <mapTargets>
    <target type="WSDL">
      <schema location="../TskDiagnosticoDAC.wsdl"/>
      <rootElement name="DiagnosticoRequest" namespace="http://xmlns.cablevision.net.mx/DrCable_SOA/DrCable/TskDiagnosticoDAC"/>
    </target>
  </mapTargets>
  <!-- GENERATED BY ORACLE XSL MAPPER 11.1.1.7.0(build 130301.0647.0008) AT [FRI OCT 25 18:03:27 CDT 2013]. -->
?>
<xsl:stylesheet version="1.0"
                xmlns:xp20="http://www.oracle.com/XSL/Transform/java/oracle.tip.pc.services.functions.Xpath20"
                xmlns:bpws="http://schemas.xmlsoap.org/ws/2003/03/business-process/"
                xmlns:bpel="http://docs.oasis-open.org/wsbpel/2.0/process/executable"
                xmlns:apachesoap="http://xml.apache.org/xml-soap"
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xmlns:bpm="http://xmlns.oracle.com/bpmn20/extensions"
                xmlns:wsdlsoap="http://schemas.xmlsoap.org/wsdl/soap/"
                xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"
                xmlns:ora="http://schemas.oracle.com/xpath/extension"
                xmlns:socket="http://www.oracle.com/XSL/Transform/java/oracle.tip.adapter.socket.ProtocolTranslator"
                xmlns:ns2="http://xmlns.cablevision.net.mx/DrCable_SOA/DrCable/TskDiagnosticoDAC"
                xmlns:mhdr="http://www.oracle.com/XSL/Transform/java/oracle.tip.mediator.service.common.functions.MediatorExtnFunction"
                xmlns:oraext="http://www.oracle.com/XSL/Transform/java/oracle.tip.pc.services.functions.ExtFunc"
                xmlns:client="http://xmlns.cablevision.net.mx/DrCable_SOA/DrCable/OrNOCGetDiagnostiDAC"
                xmlns:dvm="http://www.oracle.com/XSL/Transform/java/oracle.tip.dvm.LookupValue"
                xmlns:hwf="http://xmlns.oracle.com/bpel/workflow/xpath"
                xmlns:plnk="http://docs.oasis-open.org/wsbpel/2.0/plnktype"
                xmlns:med="http://schemas.oracle.com/mediator/xpath"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:ids="http://xmlns.oracle.com/bpel/services/IdentityService/xpath"
                xmlns:xdk="http://schemas.oracle.com/bpel/extension/xpath/function/xdk"
                xmlns:xref="http://www.oracle.com/XSL/Transform/java/oracle.tip.xref.xpath.XRefXPathFunctions"
                xmlns:xsd="http://www.w3.org/2001/XMLSchema"
                xmlns:bpmn="http://schemas.oracle.com/bpm/xpath"
                xmlns:ns1="http://dacInvoker.vitria.cablevision.com"
                xmlns:ldap="http://schemas.oracle.com/xpath/extension/ldap"
                exclude-result-prefixes="xsi xsl apachesoap wsdlsoap wsdl ns2 client plnk xsd ns1 xp20 bpws bpel bpm ora socket mhdr oraext dvm hwf med ids xdk xref bpmn ldap">
  <xsl:param name="outputDAC.parameters"/>
  <xsl:template match="/">
    <ns2:DiagnosticoRequest>
      <direccionPrincipal>
        <hub>
          <xsl:value-of select="/client:process/client:direccionPrincipal/client:hub"/>
        </hub>
        <retorno>
          <xsl:value-of select="/client:process/client:direccionPrincipal/client:retorno"/>
        </retorno>
      </direccionPrincipal>
      <itemsFacturacion>
        <xsl:for-each select="/client:process/client:itemsFacturacion/client:item">
          <item>
            <numeroSerie>
              <xsl:value-of select="client:numeroSerie"/>
            </numeroSerie>
            <producto>
              <xsl:value-of select="client:producto"/>
            </producto>
          </item>
        </xsl:for-each>
      </itemsFacturacion>
      <itemsServicio>
        <xsl:for-each select="/client:process/client:itemsServicio/client:item">
          <item>
            <numeroSerie>
              <xsl:value-of select="client:numeroSerie"/>
            </numeroSerie>
            <producto>
              <xsl:value-of select="client:producto"/>
            </producto>
            <status>
              <xsl:value-of select="client:status"/>
            </status>
          </item>
        </xsl:for-each>
      </itemsServicio>
      <responseDACVO>
        <activatedFlag>
          <xsl:value-of select="$outputDAC.parameters/ns1:invokerResponse/ns1:invokerReturn/ns1:activated_Flag"/>
        </activatedFlag>
        <creditAllowed>
          <xsl:value-of select="$outputDAC.parameters/ns1:invokerResponse/ns1:invokerReturn/ns1:credit_Allowed"/>
        </creditAllowed>
        <downstreamPlantHandle>
          <xsl:value-of select="$outputDAC.parameters/ns1:invokerResponse/ns1:invokerReturn/ns1:downstream_Plant_Handle"/>
        </downstreamPlantHandle>
        <equipType>
          <xsl:value-of select="$outputDAC.parameters/ns1:invokerResponse/ns1:invokerReturn/ns1:equip_Type"/>
        </equipType>
        <installDate>
          <xsl:value-of select="$outputDAC.parameters/ns1:invokerResponse/ns1:invokerReturn/ns1:install_Date"/>
        </installDate>
        <maxPackCost>
          <xsl:value-of select="$outputDAC.parameters/ns1:invokerResponse/ns1:invokerReturn/ns1:max_Pack_Cost"/>
        </maxPackCost>
        <onPlantFlag>
          <xsl:value-of select="$outputDAC.parameters/ns1:invokerResponse/ns1:invokerReturn/ns1:on_Plant_Flag"/>
        </onPlantFlag>
        <packageAuthorizations>
          <xsl:value-of select="$outputDAC.parameters/ns1:invokerResponse/ns1:invokerReturn/ns1:package_Authorizations"/>
        </packageAuthorizations>
        <programAuthorizations>
          <xsl:value-of select="$outputDAC.parameters/ns1:invokerResponse/ns1:invokerReturn/ns1:program_Authorizations"/>
        </programAuthorizations>
        <purchasesAllowed>
          <xsl:value-of select="$outputDAC.parameters/ns1:invokerResponse/ns1:invokerReturn/ns1:purchases_Allowed"/>
        </purchasesAllowed>
        <respondingFlag>
          <xsl:value-of select="$outputDAC.parameters/ns1:invokerResponse/ns1:invokerReturn/ns1:responding_Flag"/>
        </respondingFlag>
        <serialNUmber>
          <xsl:value-of select="$outputDAC.parameters/ns1:invokerResponse/ns1:invokerReturn/ns1:serial_NUmber"/>
        </serialNUmber>
        <serviceAuthorizations>
          <xsl:value-of select="$outputDAC.parameters/ns1:invokerResponse/ns1:invokerReturn/ns1:service_Authorizations"/>
        </serviceAuthorizations>
        <unitAddress>
          <xsl:value-of select="$outputDAC.parameters/ns1:invokerResponse/ns1:invokerReturn/ns1:unit_Address"/>
        </unitAddress>
        <upstreamPlantHandle>
          <xsl:value-of select="$outputDAC.parameters/ns1:invokerResponse/ns1:invokerReturn/ns1:upstream_Plant_Handle"/>
        </upstreamPlantHandle>
        <vcmHandle>
          <xsl:value-of select="$outputDAC.parameters/ns1:invokerResponse/ns1:invokerReturn/ns1:VCM_Handle"/>
        </vcmHandle>
      </responseDACVO>
    </ns2:DiagnosticoRequest>
  </xsl:template>
</xsl:stylesheet>