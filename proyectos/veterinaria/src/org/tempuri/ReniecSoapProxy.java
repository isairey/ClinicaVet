package org.tempuri;

public class ReniecSoapProxy implements org.tempuri.ReniecSoap {
  private String _endpoint = null;
  private org.tempuri.ReniecSoap reniecSoap = null;
  
  public ReniecSoapProxy() {
    _initReniecSoapProxy();
  }
  
  public ReniecSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initReniecSoapProxy();
  }
  
  private void _initReniecSoapProxy() {
    try {
      reniecSoap = (new org.tempuri.ReniecLocator()).getReniecSoap();
      if (reniecSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)reniecSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)reniecSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (reniecSoap != null)
      ((javax.xml.rpc.Stub)reniecSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.tempuri.ReniecSoap getReniecSoap() {
    if (reniecSoap == null)
      _initReniecSoapProxy();
    return reniecSoap;
  }
  
  public java.lang.String helloWorld() throws java.rmi.RemoteException{
    if (reniecSoap == null)
      _initReniecSoapProxy();
    return reniecSoap.helloWorld();
  }
  
  public java.lang.String GETPERSONA(java.lang.String DNI) throws java.rmi.RemoteException{
    if (reniecSoap == null)
      _initReniecSoapProxy();
    return reniecSoap.GETPERSONA(DNI);
  }
  
  
}