package io.biza.babelfish.interfaces;

import io.biza.babelfish.common.exceptions.EncryptionOperationException;
import io.biza.babelfish.common.exceptions.NotInitialisedException;

public interface CertificateService {

  /**
   * Generate Certificate from CSR using Certificate Authority
   * 
   * @return Signed Certificate in PEM format
   * @throws NotInitialisedException if unable to initialise the Certificate Authority
   * @throws EncryptionOperationException 
   */
  public String signRequest(String csr) throws NotInitialisedException, EncryptionOperationException;
  
  /**
   * Get Certificate Authority CA in PEM format
   * 
   * @return CA certificate in PEM Format
   * @throws NotInitialisedException if unable to initialise the Certificate Authority
   * @throws EncryptionOperationException 
   */
  public String getCaCertificate() throws NotInitialisedException, EncryptionOperationException;
  
  /**
   * Is Certificate Authority initialised
   * 
   * @return boolean of whether CA is initialised
   * @throws EncryptionOperationException 
   */
  public boolean isInitialised() throws EncryptionOperationException;
  
  /**
   * Perform Certificate Authority initialisation
   * @throws EncryptionOperationException 
   * 
   * @throws NotInitialisedException if unable to initialise or already initialised
   */
  public void initCa() throws EncryptionOperationException, NotInitialisedException;
  
  
}
