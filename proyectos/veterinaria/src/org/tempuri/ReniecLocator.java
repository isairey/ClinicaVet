/**
 * ReniecLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class ReniecLocator extends org.apache.axis.client.Service implements org.tempuri.Reniec {

    public ReniecLocator() {
    }


    public ReniecLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ReniecLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ReniecSoap
    private java.lang.String ReniecSoap_address = "http://localhost:13231/WSReniec/Reniec.asmx";

    public java.lang.String getReniecSoapAddress() {
        return ReniecSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ReniecSoapWSDDServiceName = "ReniecSoap";

    public java.lang.String getReniecSoapWSDDServiceName() {
        return ReniecSoapWSDDServiceName;
    }

    public void setReniecSoapWSDDServiceName(java.lang.String name) {
        ReniecSoapWSDDServiceName = name;
    }

    public org.tempuri.ReniecSoap getReniecSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ReniecSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getReniecSoap(endpoint);
    }

    public org.tempuri.ReniecSoap getReniecSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.tempuri.ReniecSoapStub _stub = new org.tempuri.ReniecSoapStub(portAddress, this);
            _stub.setPortName(getReniecSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setReniecSoapEndpointAddress(java.lang.String address) {
        ReniecSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.tempuri.ReniecSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                org.tempuri.ReniecSoapStub _stub = new org.tempuri.ReniecSoapStub(new java.net.URL(ReniecSoap_address), this);
                _stub.setPortName(getReniecSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ReniecSoap".equals(inputPortName)) {
            return getReniecSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "Reniec");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "ReniecSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ReniecSoap".equals(portName)) {
            setReniecSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
