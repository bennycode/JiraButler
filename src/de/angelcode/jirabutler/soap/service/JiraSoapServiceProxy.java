package de.angelcode.jirabutler.soap.service;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.rpc.ServiceException;

public class JiraSoapServiceProxy implements JiraSoapService
{

  private String _endpoint = null;
  private JiraSoapService jiraSoapService = null;

  public JiraSoapServiceProxy()
  {
    _initJiraSoapServiceProxy();
  }

  public JiraSoapServiceProxy(String endpoint)
  {
    _endpoint = endpoint;
    _initJiraSoapServiceProxy();
  }

  private void _initJiraSoapServiceProxy()
  {
    try
    {
      jiraSoapService = (new JiraSoapServiceServiceLocator()).getJirasoapserviceV2();
    }
    catch (ServiceException ex)
    {
      Logger.getLogger(JiraSoapServiceProxy.class.getName()).log(Level.SEVERE, null, ex);
    }
    if (jiraSoapService != null)
    {
      if (_endpoint != null)
      {
        ((javax.xml.rpc.Stub) jiraSoapService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
      }
      else
      {
        _endpoint = (String) ((javax.xml.rpc.Stub) jiraSoapService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
    }
  }

  public String getEndpoint()
  {
    return _endpoint;
  }

  public void setEndpoint(String endpoint)
  {
    _endpoint = endpoint;
    if (jiraSoapService != null)
    {
      ((javax.xml.rpc.Stub) jiraSoapService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    }

  }

  public JiraSoapService getJiraSoapService()
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService;
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteServerInfo getServerInfo(java.lang.String in0) throws java.rmi.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getServerInfo(in0);
  }

  public java.lang.String login(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.login(in0, in1);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteUser getUser(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getUser(in0, in1);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteIssue getIssue(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getIssue(in0, in1);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteVersion[] getVersions(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getVersions(in0, in1);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteUser createUser(java.lang.String in0, java.lang.String in1, java.lang.String in2, java.lang.String in3, java.lang.String in4) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteValidationException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.createUser(in0, in1, in2, in3, in4);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteIssue createIssue(java.lang.String in0, com.atlassian.jira.rpc.soap.beans.RemoteIssue in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteValidationException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.createIssue(in0, in1);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteIssue updateIssue(java.lang.String in0, java.lang.String in1, com.atlassian.jira.rpc.soap.beans.RemoteFieldValue[] in2) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.updateIssue(in0, in1, in2);
  }

  public void deleteIssue(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    jiraSoapService.deleteIssue(in0, in1);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteNamedObject[] getAvailableActions(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getAvailableActions(in0, in1);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteIssueType[] getSubTaskIssueTypes(java.lang.String in0) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getSubTaskIssueTypes(in0);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteConfiguration getConfiguration(java.lang.String in0) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getConfiguration(in0);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteProject createProject(java.lang.String in0, java.lang.String in1, java.lang.String in2, java.lang.String in3, java.lang.String in4, java.lang.String in5, com.atlassian.jira.rpc.soap.beans.RemotePermissionScheme in6, com.atlassian.jira.rpc.soap.beans.RemoteScheme in7, com.atlassian.jira.rpc.soap.beans.RemoteScheme in8) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteValidationException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.createProject(in0, in1, in2, in3, in4, in5, in6, in7, in8);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteProject updateProject(java.lang.String in0, com.atlassian.jira.rpc.soap.beans.RemoteProject in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteValidationException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.updateProject(in0, in1);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteProject getProjectByKey(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getProjectByKey(in0, in1);
  }

  public void removeAllRoleActorsByProject(java.lang.String in0, com.atlassian.jira.rpc.soap.beans.RemoteProject in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    jiraSoapService.removeAllRoleActorsByProject(in0, in1);
  }

  public com.atlassian.jira.rpc.soap.beans.RemotePriority[] getPriorities(java.lang.String in0) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getPriorities(in0);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteResolution[] getResolutions(java.lang.String in0) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getResolutions(in0);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteIssueType[] getIssueTypes(java.lang.String in0) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getIssueTypes(in0);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteStatus[] getStatuses(java.lang.String in0) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getStatuses(in0);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteIssueType[] getIssueTypesForProject(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getIssueTypesForProject(in0, in1);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteProjectRole[] getProjectRoles(java.lang.String in0) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getProjectRoles(in0);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteProjectRole getProjectRole(java.lang.String in0, long in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getProjectRole(in0, in1);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteProjectRoleActors getProjectRoleActors(java.lang.String in0, com.atlassian.jira.rpc.soap.beans.RemoteProjectRole in1, com.atlassian.jira.rpc.soap.beans.RemoteProject in2) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getProjectRoleActors(in0, in1, in2);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteRoleActors getDefaultRoleActors(java.lang.String in0, com.atlassian.jira.rpc.soap.beans.RemoteProjectRole in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getDefaultRoleActors(in0, in1);
  }

  public void removeAllRoleActorsByNameAndType(java.lang.String in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    jiraSoapService.removeAllRoleActorsByNameAndType(in0, in1, in2);
  }

  public void deleteProjectRole(java.lang.String in0, com.atlassian.jira.rpc.soap.beans.RemoteProjectRole in1, boolean in2) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    jiraSoapService.deleteProjectRole(in0, in1, in2);
  }

  public void updateProjectRole(java.lang.String in0, com.atlassian.jira.rpc.soap.beans.RemoteProjectRole in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    jiraSoapService.updateProjectRole(in0, in1);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteProjectRole createProjectRole(java.lang.String in0, com.atlassian.jira.rpc.soap.beans.RemoteProjectRole in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.createProjectRole(in0, in1);
  }

  public boolean isProjectRoleNameUnique(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.isProjectRoleNameUnique(in0, in1);
  }

  public void addActorsToProjectRole(java.lang.String in0, java.lang.String[] in1, com.atlassian.jira.rpc.soap.beans.RemoteProjectRole in2, com.atlassian.jira.rpc.soap.beans.RemoteProject in3, java.lang.String in4) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    jiraSoapService.addActorsToProjectRole(in0, in1, in2, in3, in4);
  }

  public void removeActorsFromProjectRole(java.lang.String in0, java.lang.String[] in1, com.atlassian.jira.rpc.soap.beans.RemoteProjectRole in2, com.atlassian.jira.rpc.soap.beans.RemoteProject in3, java.lang.String in4) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    jiraSoapService.removeActorsFromProjectRole(in0, in1, in2, in3, in4);
  }

  public void addDefaultActorsToProjectRole(java.lang.String in0, java.lang.String[] in1, com.atlassian.jira.rpc.soap.beans.RemoteProjectRole in2, java.lang.String in3) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    jiraSoapService.addDefaultActorsToProjectRole(in0, in1, in2, in3);
  }

  public void removeDefaultActorsFromProjectRole(java.lang.String in0, java.lang.String[] in1, com.atlassian.jira.rpc.soap.beans.RemoteProjectRole in2, java.lang.String in3) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    jiraSoapService.removeDefaultActorsFromProjectRole(in0, in1, in2, in3);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteScheme[] getAssociatedNotificationSchemes(java.lang.String in0, com.atlassian.jira.rpc.soap.beans.RemoteProjectRole in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getAssociatedNotificationSchemes(in0, in1);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteScheme[] getAssociatedPermissionSchemes(java.lang.String in0, com.atlassian.jira.rpc.soap.beans.RemoteProjectRole in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getAssociatedPermissionSchemes(in0, in1);
  }

  public void deleteProject(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    jiraSoapService.deleteProject(in0, in1);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteProject getProjectById(java.lang.String in0, long in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getProjectById(in0, in1);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteField[] getCustomFields(java.lang.String in0) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getCustomFields(in0);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteComment[] getComments(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getComments(in0, in1);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteFilter[] getFavouriteFilters(java.lang.String in0) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getFavouriteFilters(in0);
  }

  public void releaseVersion(java.lang.String in0, java.lang.String in1, com.atlassian.jira.rpc.soap.beans.RemoteVersion in2) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    jiraSoapService.releaseVersion(in0, in1, in2);
  }

  public void archiveVersion(java.lang.String in0, java.lang.String in1, java.lang.String in2, boolean in3) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    jiraSoapService.archiveVersion(in0, in1, in2, in3);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteField[] getFieldsForEdit(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getFieldsForEdit(in0, in1);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteIssueType[] getSubTaskIssueTypesForProject(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getSubTaskIssueTypesForProject(in0, in1);
  }

  public void addUserToGroup(java.lang.String in0, com.atlassian.jira.rpc.soap.beans.RemoteGroup in1, com.atlassian.jira.rpc.soap.beans.RemoteUser in2) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteValidationException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    jiraSoapService.addUserToGroup(in0, in1, in2);
  }

  public void removeUserFromGroup(java.lang.String in0, com.atlassian.jira.rpc.soap.beans.RemoteGroup in1, com.atlassian.jira.rpc.soap.beans.RemoteUser in2) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteValidationException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    jiraSoapService.removeUserFromGroup(in0, in1, in2);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteSecurityLevel getSecurityLevel(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getSecurityLevel(in0, in1);
  }

  public boolean logout(java.lang.String in0) throws java.rmi.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.logout(in0);
  }

  public void addComment(java.lang.String in0, java.lang.String in1, com.atlassian.jira.rpc.soap.beans.RemoteComment in2) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    jiraSoapService.addComment(in0, in1, in2);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteProject getProjectWithSchemesById(java.lang.String in0, long in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getProjectWithSchemesById(in0, in1);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteSecurityLevel[] getSecurityLevels(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getSecurityLevels(in0, in1);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteAvatar[] getProjectAvatars(java.lang.String in0, java.lang.String in1, boolean in2) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getProjectAvatars(in0, in1, in2);
  }

  public void setProjectAvatar(java.lang.String in0, java.lang.String in1, long in2) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    jiraSoapService.setProjectAvatar(in0, in1, in2);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteAvatar getProjectAvatar(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getProjectAvatar(in0, in1);
  }

  public void deleteProjectAvatar(java.lang.String in0, long in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    jiraSoapService.deleteProjectAvatar(in0, in1);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteScheme[] getNotificationSchemes(java.lang.String in0) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getNotificationSchemes(in0);
  }

  public com.atlassian.jira.rpc.soap.beans.RemotePermissionScheme[] getPermissionSchemes(java.lang.String in0) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getPermissionSchemes(in0);
  }

  public com.atlassian.jira.rpc.soap.beans.RemotePermission[] getAllPermissions(java.lang.String in0) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getAllPermissions(in0);
  }

  public com.atlassian.jira.rpc.soap.beans.RemotePermissionScheme createPermissionScheme(java.lang.String in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteValidationException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.createPermissionScheme(in0, in1, in2);
  }

  public com.atlassian.jira.rpc.soap.beans.RemotePermissionScheme addPermissionTo(java.lang.String in0, com.atlassian.jira.rpc.soap.beans.RemotePermissionScheme in1, com.atlassian.jira.rpc.soap.beans.RemotePermission in2, com.atlassian.jira.rpc.soap.beans.RemoteEntity in3) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteValidationException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.addPermissionTo(in0, in1, in2, in3);
  }

  public com.atlassian.jira.rpc.soap.beans.RemotePermissionScheme deletePermissionFrom(java.lang.String in0, com.atlassian.jira.rpc.soap.beans.RemotePermissionScheme in1, com.atlassian.jira.rpc.soap.beans.RemotePermission in2, com.atlassian.jira.rpc.soap.beans.RemoteEntity in3) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteValidationException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.deletePermissionFrom(in0, in1, in2, in3);
  }

  public void deletePermissionScheme(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteValidationException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    jiraSoapService.deletePermissionScheme(in0, in1);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteIssue createIssueWithSecurityLevel(java.lang.String in0, com.atlassian.jira.rpc.soap.beans.RemoteIssue in1, long in2) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteValidationException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.createIssueWithSecurityLevel(in0, in1, in2);
  }

  public boolean addAttachmentsToIssue(java.lang.String in0, java.lang.String in1, java.lang.String[] in2, byte[][] in3) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteValidationException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.addAttachmentsToIssue(in0, in1, in2, in3);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteAttachment[] getAttachmentsFromIssue(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteValidationException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getAttachmentsFromIssue(in0, in1);
  }

  public boolean hasPermissionToEditComment(java.lang.String in0, com.atlassian.jira.rpc.soap.beans.RemoteComment in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.hasPermissionToEditComment(in0, in1);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteComment editComment(java.lang.String in0, com.atlassian.jira.rpc.soap.beans.RemoteComment in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.editComment(in0, in1);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteField[] getFieldsForAction(java.lang.String in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getFieldsForAction(in0, in1, in2);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteIssue progressWorkflowAction(java.lang.String in0, java.lang.String in1, java.lang.String in2, com.atlassian.jira.rpc.soap.beans.RemoteFieldValue[] in3) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.progressWorkflowAction(in0, in1, in2, in3);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteIssue getIssueById(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getIssueById(in0, in1);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteWorklog addWorklogWithNewRemainingEstimate(java.lang.String in0, java.lang.String in1, com.atlassian.jira.rpc.soap.beans.RemoteWorklog in2, java.lang.String in3) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteValidationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.addWorklogWithNewRemainingEstimate(in0, in1, in2, in3);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteWorklog addWorklogAndAutoAdjustRemainingEstimate(java.lang.String in0, java.lang.String in1, com.atlassian.jira.rpc.soap.beans.RemoteWorklog in2) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteValidationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.addWorklogAndAutoAdjustRemainingEstimate(in0, in1, in2);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteWorklog addWorklogAndRetainRemainingEstimate(java.lang.String in0, java.lang.String in1, com.atlassian.jira.rpc.soap.beans.RemoteWorklog in2) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteValidationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.addWorklogAndRetainRemainingEstimate(in0, in1, in2);
  }

  public void deleteWorklogWithNewRemainingEstimate(java.lang.String in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteValidationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    jiraSoapService.deleteWorklogWithNewRemainingEstimate(in0, in1, in2);
  }

  public void deleteWorklogAndAutoAdjustRemainingEstimate(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteValidationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    jiraSoapService.deleteWorklogAndAutoAdjustRemainingEstimate(in0, in1);
  }

  public void deleteWorklogAndRetainRemainingEstimate(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteValidationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    jiraSoapService.deleteWorklogAndRetainRemainingEstimate(in0, in1);
  }

  public void updateWorklogWithNewRemainingEstimate(java.lang.String in0, com.atlassian.jira.rpc.soap.beans.RemoteWorklog in1, java.lang.String in2) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteValidationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    jiraSoapService.updateWorklogWithNewRemainingEstimate(in0, in1, in2);
  }

  public void updateWorklogAndAutoAdjustRemainingEstimate(java.lang.String in0, com.atlassian.jira.rpc.soap.beans.RemoteWorklog in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteValidationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    jiraSoapService.updateWorklogAndAutoAdjustRemainingEstimate(in0, in1);
  }

  public void updateWorklogAndRetainRemainingEstimate(java.lang.String in0, com.atlassian.jira.rpc.soap.beans.RemoteWorklog in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteValidationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    jiraSoapService.updateWorklogAndRetainRemainingEstimate(in0, in1);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteWorklog[] getWorklogs(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteValidationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getWorklogs(in0, in1);
  }

  public boolean hasPermissionToCreateWorklog(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemoteValidationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.hasPermissionToCreateWorklog(in0, in1);
  }

  public boolean hasPermissionToDeleteWorklog(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemoteValidationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.hasPermissionToDeleteWorklog(in0, in1);
  }

  public boolean hasPermissionToUpdateWorklog(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemoteValidationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.hasPermissionToUpdateWorklog(in0, in1);
  }

  public java.util.Calendar getResolutionDateByKey(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getResolutionDateByKey(in0, in1);
  }

  public java.util.Calendar getResolutionDateById(java.lang.String in0, long in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getResolutionDateById(in0, in1);
  }

  public long getIssueCountForFilter(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getIssueCountForFilter(in0, in1);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteIssue[] getIssuesFromTextSearch(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getIssuesFromTextSearch(in0, in1);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteIssue[] getIssuesFromTextSearchWithProject(java.lang.String in0, java.lang.String[] in1, java.lang.String in2, int in3) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getIssuesFromTextSearchWithProject(in0, in1, in2, in3);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteIssue[] getIssuesFromJqlSearch(java.lang.String in0, java.lang.String in1, int in2) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getIssuesFromJqlSearch(in0, in1, in2);
  }

  public void deleteUser(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteValidationException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    jiraSoapService.deleteUser(in0, in1);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteGroup updateGroup(java.lang.String in0, com.atlassian.jira.rpc.soap.beans.RemoteGroup in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteValidationException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.updateGroup(in0, in1);
  }

  public void deleteGroup(java.lang.String in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteValidationException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    jiraSoapService.deleteGroup(in0, in1, in2);
  }

  public void refreshCustomFields(java.lang.String in0) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    jiraSoapService.refreshCustomFields(in0);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteFilter[] getSavedFilters(java.lang.String in0) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getSavedFilters(in0);
  }

  public boolean addBase64EncodedAttachmentsToIssue(java.lang.String in0, java.lang.String in1, java.lang.String[] in2, java.lang.String[] in3) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteValidationException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.addBase64EncodedAttachmentsToIssue(in0, in1, in2, in3);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteProject createProjectFromObject(java.lang.String in0, com.atlassian.jira.rpc.soap.beans.RemoteProject in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteValidationException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.createProjectFromObject(in0, in1);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteScheme[] getSecuritySchemes(java.lang.String in0) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getSecuritySchemes(in0);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteVersion addVersion(java.lang.String in0, java.lang.String in1, com.atlassian.jira.rpc.soap.beans.RemoteVersion in2) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.addVersion(in0, in1, in2);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteIssue[] getIssuesFromFilter(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getIssuesFromFilter(in0, in1);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteIssue[] getIssuesFromFilterWithLimit(java.lang.String in0, java.lang.String in1, int in2, int in3) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getIssuesFromFilterWithLimit(in0, in1, in2, in3);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteIssue[] getIssuesFromTextSearchWithLimit(java.lang.String in0, java.lang.String in1, int in2, int in3) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getIssuesFromTextSearchWithLimit(in0, in1, in2, in3);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteProject[] getProjectsNoSchemes(java.lang.String in0) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getProjectsNoSchemes(in0);
  }

  public void setNewProjectAvatar(java.lang.String in0, java.lang.String in1, java.lang.String in2, java.lang.String in3) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    jiraSoapService.setNewProjectAvatar(in0, in1, in2, in3);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteComponent[] getComponents(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getComponents(in0, in1);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteGroup createGroup(java.lang.String in0, java.lang.String in1, com.atlassian.jira.rpc.soap.beans.RemoteUser in2) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteValidationException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.createGroup(in0, in1, in2);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteComment getComment(java.lang.String in0, long in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getComment(in0, in1);
  }

  public com.atlassian.jira.rpc.soap.beans.RemoteGroup getGroup(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteValidationException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException, com.atlassian.jira.rpc.exception.RemoteException
  {
    if (jiraSoapService == null)
    {
      _initJiraSoapServiceProxy();
    }
    return jiraSoapService.getGroup(in0, in1);
  }
}
