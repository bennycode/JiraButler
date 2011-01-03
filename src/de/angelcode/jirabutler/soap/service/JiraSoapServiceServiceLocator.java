/**
 * JiraSoapServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */
package de.angelcode.jirabutler.soap.service;

import java.rmi.Remote;

public class JiraSoapServiceServiceLocator extends org.apache.axis.client.Service implements JiraSoapServiceService
{
  private String connectionUrl;
  private String JirasoapserviceV2_address;

  public JiraSoapServiceServiceLocator(String connectionUrl)
  {
    this.connectionUrl = connectionUrl;
    this.JirasoapserviceV2_address = connectionUrl;
  }

  public JiraSoapServiceServiceLocator(org.apache.axis.EngineConfiguration config)
  {
    super(config);
  }

  public JiraSoapServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException
  {
    super(wsdlLoc, sName);
  }

  // Use to get a proxy class for JirasoapserviceV2
  //private java.lang.String JirasoapserviceV2_address = "http://www.angelcode.de:8080//rpc/soap/jirasoapservice-v2";
  

  public java.lang.String getJirasoapserviceV2Address()
  {
    return JirasoapserviceV2_address;
  }
  // The WSDD service name defaults to the port name.
  private java.lang.String JirasoapserviceV2WSDDServiceName = "jirasoapservice-v2";

  public java.lang.String getJirasoapserviceV2WSDDServiceName()
  {
    return JirasoapserviceV2WSDDServiceName;
  }

  public void setJirasoapserviceV2WSDDServiceName(java.lang.String name)
  {
    JirasoapserviceV2WSDDServiceName = name;
  }

  public JiraSoapService getJirasoapserviceV2() throws javax.xml.rpc.ServiceException
  {
    java.net.URL endpoint;
    try
    {
      System.out.println("===============================================================");
      System.out.println(JirasoapserviceV2_address);
      endpoint = new java.net.URL(JirasoapserviceV2_address);
    }
    catch (java.net.MalformedURLException e)
    {
      throw new javax.xml.rpc.ServiceException(e);
    }
    return getJirasoapserviceV2(endpoint);
  }

  public JiraSoapService getJirasoapserviceV2(java.net.URL portAddress) throws javax.xml.rpc.ServiceException
  {
    try
    {
      JirasoapserviceV2SoapBindingStub _stub = new JirasoapserviceV2SoapBindingStub(portAddress, this, this.connectionUrl);
      _stub.setPortName(getJirasoapserviceV2WSDDServiceName());
      return (JiraSoapService) _stub;
    }
    catch (org.apache.axis.AxisFault e)
    {
      return null;
    }
  }

  public void setJirasoapserviceV2EndpointAddress(java.lang.String address)
  {
    JirasoapserviceV2_address = address;
  }

  /**
   * For the given interface, get the stub implementation.
   * If this service has no port for the given interface,
   * then ServiceException is thrown.
   */
  @Override
  public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException
  {
    try
    {
      if (JiraSoapService.class.isAssignableFrom(serviceEndpointInterface))
      {
        JirasoapserviceV2SoapBindingStub _stub = new JirasoapserviceV2SoapBindingStub(new java.net.URL(JirasoapserviceV2_address), this, this.connectionUrl);
        _stub.setPortName(getJirasoapserviceV2WSDDServiceName());
        return (Remote) _stub;
      }
    }
    catch (java.lang.Throwable t)
    {
      throw new javax.xml.rpc.ServiceException(t);
    }
    throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
  }

  /**
   * For the given interface, get the stub implementation.
   * If this service has no port for the given interface,
   * then ServiceException is thrown.
   */
  @Override
  public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException
  {
    if (portName == null)
    {
      return getPort(serviceEndpointInterface);
    }
    java.lang.String inputPortName = portName.getLocalPart();
    if ("jirasoapservice-v2".equals(inputPortName))
    {
      return getJirasoapserviceV2();
    }
    else
    {
      java.rmi.Remote _stub = getPort(serviceEndpointInterface);
      ((org.apache.axis.client.Stub) _stub).setPortName(portName);
      return _stub;
    }
  }

  @Override
  public javax.xml.namespace.QName getServiceName()
  {
    return new javax.xml.namespace.QName(this.connectionUrl, "JiraSoapServiceService");
  }
  private java.util.HashSet ports = null;

  @Override
  public java.util.Iterator getPorts()
  {
    if (ports == null)
    {
      ports = new java.util.HashSet();
      ports.add(new javax.xml.namespace.QName(this.connectionUrl, "jirasoapservice-v2"));
    }
    return ports.iterator();
  }

  /**
   * Set the endpoint address for the specified port name.
   */
  public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException
  {

    if ("JirasoapserviceV2".equals(portName))
    {
      setJirasoapserviceV2EndpointAddress(address);
    }
    else
    { // Unknown Port Name
      throw new javax.xml.rpc.ServiceException("Cannot set Endpoint Address for Unknown Port" + portName);
    }
  }

  /**
   * Set the endpoint address for the specified port name.
   */
  public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException
  {
    setEndpointAddress(portName.getLocalPart(), address);
  }
}
