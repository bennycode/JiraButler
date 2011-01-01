package mypackage;

import de.angelcode.jirabutler.hook.JiraServiceHook;
import de.angelcode.jirabutler.soap.JiraController;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.text.ParseException;

public class MyMain
{
  public static void main(String[] args) throws Exception
  {
    String json1 = "payload=%7b%22before%22%3a%222defbf56e1de2b1807118cd013bf8980471fabd5%22%2c%22commits%22%3a%5b%7b%22author%22%3a%7b%22username%22%3a%22bennyn%22%2c%22email%22%3a%22bn%40bennyn.de%22%2c%22name%22%3a%22Benny%20Neugebauer%22%7d%2c%22timestamp%22%3a%222011-01-01T10%3a04%3a10-08%3a00%22%2c%22added%22%3a%5b%5d%2c%22message%22%3a%22SWQ-8@Updated%20JAR%22%2c%22modified%22%3a%5b%22build%5c%2fjar%5c%2fJiraButler-0.1.jar%22%5d%2c%22url%22%3a%22https%3a%5c%2f%5c%2fgithub.com%5c%2fbennyn%5c%2fJiraButler%5c%2fcommit%5c%2f04c18485d4a6394eaf7afa7c4aa36f28d95eb9e9%22%2c%22removed%22%3a%5b%5d%2c%22id%22%3a%2204c18485d4a6394eaf7afa7c4aa36f28d95eb9e9%22%7d%5d%2c%22after%22%3a%2204c18485d4a6394eaf7afa7c4aa36f28d95eb9e9%22%2c%22pusher%22%3a%7b%22email%22%3a%22bn%40bennyn.de%22%2c%22name%22%3a%22bennyn%22%7d%2c%22repository%22%3a%7b%22has_downloads%22%3atrue%2c%22has_wiki%22%3atrue%2c%22watchers%22%3a1%2c%22description%22%3a%22Test%22%2c%22url%22%3a%22https%3a%5c%2f%5c%2fgithub.com%5c%2fbennyn%5c%2fJiraButler%22%2c%22fork%22%3afalse%2c%22open_issues%22%3a0%2c%22private%22%3afalse%2c%22forks%22%3a1%2c%22pushed_at%22%3a%222011%2f01%2f01%2010%3a04%3a17%20-0800%22%2c%22created_at%22%3a%222010%2f12%2f30%2020%3a28%3a05%20-0800%22%2c%22owner%22%3a%7b%22email%22%3a%22bn%40bennyn.de%22%2c%22name%22%3a%22bennyn%22%7d%2c%22name%22%3a%22JiraButler%22%2c%22has_issues%22%3atrue%2c%22homepage%22%3a%22%22%7d%2c%22compare%22%3a%22https%3a%5c%2f%5c%2fgithub.com%5c%2fbennyn%5c%2fJiraButler%5c%2fcompare%5c%2f2defbf5...04c1848%22%2c%22ref%22%3a%22refs%5c%2fheads%5c%2fmaster%22%2c%22forced%22%3afalse%7d";
    String json2 = "payload=%7b%22commits%22%3a%5b%7b%22author%22%3a%7b%22username%22%3a%22Scarfake%22%2c%22email%22%3a%22robert.benedikt%40gmx.de%22%2c%22name%22%3a%22Scarfake%22%7d%2c%22timestamp%22%3a%222010-12-01T02%3a00%3a22-08%3a00%22%2c%22added%22%3a%5b%22classes%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fexception%5c%2fRemoteAuthenticationException.class%22%2c%22classes%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fexception%5c%2fRemoteException.class%22%2c%22classes%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fexception%5c%2fRemotePermissionException.class%22%2c%22classes%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fexception%5c%2fRemoteValidationException.class%22%2c%22classes%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fAbstractNamedRemoteEntity.class%22%2c%22classes%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fAbstractRemoteConstant.class%22%2c%22classes%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fAbstractRemoteEntity.class%22%2c%22classes%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteAttachment.class%22%2c%22classes%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteAvatar.class%22%2c%22classes%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteComment.class%22%2c%22classes%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteComponent.class%22%2c%22classes%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteConfiguration.class%22%2c%22classes%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteCustomFieldValue.class%22%2c%22classes%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteEntity.class%22%2c%22classes%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteField.class%22%2c%22classes%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteFieldValue.class%22%2c%22classes%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteFilter.class%22%2c%22classes%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteGroup.class%22%2c%22classes%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteIssue.class%22%2c%22classes%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteIssueType.class%22%2c%22classes%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteNamedObject.class%22%2c%22classes%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemotePermission.class%22%2c%22classes%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemotePermissionMapping.class%22%2c%22classes%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemotePermissionScheme.class%22%2c%22classes%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemotePriority.class%22%2c%22classes%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteProject.class%22%2c%22classes%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteProjectRole.class%22%2c%22classes%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteProjectRoleActors.class%22%2c%22classes%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteResolution.class%22%2c%22classes%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteRoleActor.class%22%2c%22classes%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteRoleActors.class%22%2c%22classes%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteScheme.class%22%2c%22classes%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteSecurityLevel.class%22%2c%22classes%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteServerInfo.class%22%2c%22classes%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteStatus.class%22%2c%22classes%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteTimeInfo.class%22%2c%22classes%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteUser.class%22%2c%22classes%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteVersion.class%22%2c%22classes%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteWorklog.class%22%2c%22classes%5c%2fde%5c%2fangelcode%5c%2frpc%5c%2fsoap%5c%2fservice%5c%2fJiraClient.class%22%2c%22classes%5c%2fde%5c%2fangelcode%5c%2frpc%5c%2fsoap%5c%2fservice%5c%2fJiraClientImpl.class%22%2c%22classes%5c%2fde%5c%2fangelcode%5c%2frpc%5c%2fsoap%5c%2fservice%5c%2fJiraClientImplTest.class%22%2c%22classes%5c%2fde%5c%2fangelcode%5c%2frpc%5c%2fsoap%5c%2fservice%5c%2fJiraSoapService.class%22%2c%22classes%5c%2fde%5c%2fangelcode%5c%2frpc%5c%2fsoap%5c%2fservice%5c%2fJiraSoapServiceProxy.class%22%2c%22classes%5c%2fde%5c%2fangelcode%5c%2frpc%5c%2fsoap%5c%2fservice%5c%2fJiraSoapServiceService.class%22%2c%22classes%5c%2fde%5c%2fangelcode%5c%2frpc%5c%2fsoap%5c%2fservice%5c%2fJiraSoapServiceServiceLocator.class%22%2c%22classes%5c%2fde%5c%2fangelcode%5c%2frpc%5c%2fsoap%5c%2fservice%5c%2fJirasoapserviceV2SoapBindingStub.class%22%2c%22lib%5c%2fcommons-discovery-0.2.jar%22%2c%22lib%5c%2feasymock-3.0.jar%22%2c%22lib%5c%2fjavax.wsdl_1.6.2.v201005080631.jar%22%2c%22lib%5c%2fjaxrpc.jar%22%2c%22lib%5c%2forg.apache.commons.logging_1.0.4.v201005080501.jar%22%2c%22lib%5c%2fsaaj.jar%22%2c%22reports%5c%2fhtml%5c%2fall-tests.html%22%2c%22reports%5c%2fhtml%5c%2fallclasses-frame.html%22%2c%22reports%5c%2fhtml%5c%2falltests-errors.html%22%2c%22reports%5c%2fhtml%5c%2falltests-fails.html%22%2c%22reports%5c%2fhtml%5c%2fde%5c%2fangelcode%5c%2frpc%5c%2fsoap%5c%2fservice%5c%2f0_JiraClientImplTest-errors.html%22%2c%22reports%5c%2fhtml%5c%2fde%5c%2fangelcode%5c%2frpc%5c%2fsoap%5c%2fservice%5c%2f0_JiraClientImplTest-out.txt%22%2c%22reports%5c%2fhtml%5c%2fde%5c%2fangelcode%5c%2frpc%5c%2fsoap%5c%2fservice%5c%2f0_JiraClientImplTest.html%22%2c%22reports%5c%2fhtml%5c%2fde%5c%2fangelcode%5c%2frpc%5c%2fsoap%5c%2fservice%5c%2fpackage-frame.html%22%2c%22reports%5c%2fhtml%5c%2fde%5c%2fangelcode%5c%2frpc%5c%2fsoap%5c%2fservice%5c%2fpackage-summary.html%22%2c%22reports%5c%2fhtml%5c%2findex.html%22%2c%22reports%5c%2fhtml%5c%2foverview-frame.html%22%2c%22reports%5c%2fhtml%5c%2foverview-summary.html%22%2c%22reports%5c%2fhtml%5c%2fstylesheet.css%22%2c%22reports%5c%2fxml%5c%2fTEST-de.angelcode.rpc.soap.service.JiraClientImplTest.xml%22%2c%22reports%5c%2fxml%5c%2fTESTS-TestSuites.xml%22%5d%2c%22url%22%3a%22https%3a%5c%2f%5c%2fgithub.com%5c%2fbennyn%5c%2fJIR-Git%5c%2fcommit%5c%2fbec3916f8e78ec9b5631089ee4aca3bf35b96c52%22%2c%22removed%22%3a%5b%5d%2c%22message%22%3a%22add%20libraries%20for%20build%20script%22%2c%22modified%22%3a%5b%5d%2c%22id%22%3a%22bec3916f8e78ec9b5631089ee4aca3bf35b96c52%22%7d%2c%7b%22author%22%3a%7b%22username%22%3a%22Scarfake%22%2c%22email%22%3a%22robert.benedikt%40gmx.de%22%2c%22name%22%3a%22Scarfake%22%7d%2c%22timestamp%22%3a%222010-12-01T03%3a52%3a33-08%3a00%22%2c%22added%22%3a%5b%22README.txt%22%5d%2c%22url%22%3a%22https%3a%5c%2f%5c%2fgithub.com%5c%2fbennyn%5c%2fJIR-Git%5c%2fcommit%5c%2f14b3a005eb5303fee9330808093d6bc6e3baffbc%22%2c%22removed%22%3a%5b%22readme.txt%22%5d%2c%22message%22%3a%22initial%20commit%22%2c%22modified%22%3a%5b%5d%2c%22id%22%3a%2214b3a005eb5303fee9330808093d6bc6e3baffbc%22%7d%2c%7b%22author%22%3a%7b%22username%22%3a%22Scarfake%22%2c%22email%22%3a%22robert.benedikt%40gmx.de%22%2c%22name%22%3a%22Scarfake%22%7d%2c%22timestamp%22%3a%222010-12-01T06%3a23%3a59-08%3a00%22%2c%22added%22%3a%5b%22classes%5c%2fde%5c%2ffhb%5c%2fjirgit%5c%2fexception%5c%2fJIRAException.class%22%2c%22classes%5c%2fde%5c%2ffhb%5c%2fjirgit%5c%2fexception%5c%2fNoValidLoginException.class%22%2c%22classes%5c%2fde%5c%2ffhb%5c%2fjirgit%5c%2fexception%5c%2fVoidParameterException.class%22%2c%22cob-instr%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fexception%5c%2fRemoteAuthenticationException.class%22%2c%22cob-instr%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fexception%5c%2fRemoteException.class%22%2c%22cob-instr%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fexception%5c%2fRemotePermissionException.class%22%2c%22cob-instr%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fexception%5c%2fRemoteValidationException.class%22%2c%22cob-instr%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fAbstractNamedRemoteEntity.class%22%2c%22cob-instr%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fAbstractRemoteConstant.class%22%2c%22cob-instr%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fAbstractRemoteEntity.class%22%2c%22cob-instr%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteAttachment.class%22%2c%22cob-instr%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteAvatar.class%22%2c%22cob-instr%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteComment.class%22%2c%22cob-instr%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteComponent.class%22%2c%22cob-instr%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteConfiguration.class%22%2c%22cob-instr%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteCustomFieldValue.class%22%2c%22cob-instr%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteEntity.class%22%2c%22cob-instr%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteField.class%22%2c%22cob-instr%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteFieldValue.class%22%2c%22cob-instr%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteFilter.class%22%2c%22cob-instr%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteGroup.class%22%2c%22cob-instr%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteIssue.class%22%2c%22cob-instr%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteIssueType.class%22%2c%22cob-instr%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteNamedObject.class%22%2c%22cob-instr%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemotePermission.class%22%2c%22cob-instr%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemotePermissionMapping.class%22%2c%22cob-instr%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemotePermissionScheme.class%22%2c%22cob-instr%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemotePriority.class%22%2c%22cob-instr%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteProject.class%22%2c%22cob-instr%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteProjectRole.class%22%2c%22cob-instr%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteProjectRoleActors.class%22%2c%22cob-instr%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteResolution.class%22%2c%22cob-instr%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteRoleActor.class%22%2c%22cob-instr%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteRoleActors.class%22%2c%22cob-instr%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteScheme.class%22%2c%22cob-instr%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteSecurityLevel.class%22%2c%22cob-instr%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteServerInfo.class%22%2c%22cob-instr%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteStatus.class%22%2c%22cob-instr%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteTimeInfo.class%22%2c%22cob-instr%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteUser.class%22%2c%22cob-instr%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteVersion.class%22%2c%22cob-instr%5c%2fcom%5c%2fatlassian%5c%2fjira%5c%2frpc%5c%2fsoap%5c%2fbeans%5c%2fRemoteWorklog.class%22%2c%22cob-instr%5c%2fde%5c%2fangelcode%5c%2frpc%5c%2fsoap%5c%2fservice%5c%2fJiraClient.class%22%2c%22cob-instr%5c%2fde%5c%2fangelcode%5c%2frpc%5c%2fsoap%5c%2fservice%5c%2fJiraClientImpl.class%22%2c%22cob-instr%5c%2fde%5c%2fangelcode%5c%2frpc%5c%2fsoap%5c%2fservice%5c%2fJiraSoapServiceProxy.class%22%2c%22cob-instr%5c%2fde%5c%2fangelcode%5c%2frpc%5c%2fsoap%5c%2fservice%5c%2fJiraSoapServiceServiceLocator.class%22%2c%22cob-instr%5c%2fde%5c%2fangelcode%5c%2frpc%5c%2fsoap%5c%2fservice%5c%2fJirasoapserviceV2SoapBindingStub.class%22%2c%22cob-instr%5c%2fde%5c%2ffhb%5c%2fjirgit%5c%2fexception%5c%2fJIRAException.class%22%2c%22cob-instr%5c%2fde%5c%2ffhb%5c%2fjirgit%5c%2fexception%5c%2fNoValidLoginException.class%22%2c%22cob-instr%5c%2fde%5c%2ffhb%5c%2fjirgit%5c%2fexception%5c%2fVoidParameterException.class%22%2c%22cob-rep%5c%2fhtml%5c%2fcom.atlassian.jira.rpc.exception.RemoteAuthenticationException.html%22%2c%22cob-rep%5c%2fhtml%5c%2fcom.atlassian.jira.rpc.exception.RemoteException.html%22%2c%22cob-rep%5c%2fhtml%5c%2fcom.atlassian.jira.rpc.exception.RemotePermissionException.html%22%2c%22cob-rep%5c%2fhtml%5c%2fcom.atlassian.jira.rpc.exception.RemoteValidationException.html%22%2c%22cob-rep%5c%2fhtml%5c%2fcom.atlassian.jira.rpc.soap.beans.AbstractNamedRemoteEntity.html%22%2c%22cob-rep%5c%2fhtml%5c%2fcom.atlassian.jira.rpc.soap.beans.AbstractRemoteConstant.html%22%2c%22cob-rep%5c%2fhtml%5c%2fcom.atlassian.jira.rpc.soap.beans.AbstractRemoteEntity.html%22%2c%22cob-rep%5c%2fhtml%5c%2fcom.atlassian.jira.rpc.soap.beans.RemoteAttachment.html%22%2c%22cob-rep%5c%2fhtml%5c%2fcom.atlassian.jira.rpc.soap.beans.RemoteAvatar.html%22%2c%22cob-rep%5c%2fhtml%5c%2fcom.atlassian.jira.rpc.soap.beans.RemoteComment.html%22%2c%22cob-rep%5c%2fhtml%5c%2fcom.atlassian.jira.rpc.soap.beans.RemoteComponent.html%22%2c%22cob-rep%5c%2fhtml%5c%2fcom.atlassian.jira.rpc.soap.beans.RemoteConfiguration.html%22%2c%22cob-rep%5c%2fhtml%5c%2fcom.atlassian.jira.rpc.soap.beans.RemoteCustomFieldValue.html%22%2c%22cob-rep%5c%2fhtml%5c%2fcom.atlassian.jira.rpc.soap.beans.RemoteEntity.html%22%2c%22cob-rep%5c%2fhtml%5c%2fcom.atlassian.jira.rpc.soap.beans.RemoteField.html%22%2c%22cob-rep%5c%2fhtml%5c%2fcom.atlassian.jira.rpc.soap.beans.RemoteFieldValue.html%22%2c%22cob-rep%5c%2fhtml%5c%2fcom.atlassian.jira.rpc.soap.beans.RemoteFilter.html%22%2c%22cob-rep%5c%2fhtml%5c%2fcom.atlassian.jira.rpc.soap.beans.RemoteGroup.html%22%2c%22cob-rep%5c%2fhtml%5c%2fcom.atlassian.jira.rpc.soap.beans.RemoteIssue.html%22%2c%22cob-rep%5c%2fhtml%5c%2fcom.atlassian.jira.rpc.soap.beans.RemoteIssueType.html%22%2c%22cob-rep%5c%2fhtml%5c%2fcom.atlassian.jira.rpc.soap.beans.RemoteNamedObject.html%22%2c%22cob-rep%5c%2fhtml%5c%2fcom.atlassian.jira.rpc.soap.beans.RemotePermission.html%22%2c%22cob-rep%5c%2fhtml%5c%2fcom.atlassian.jira.rpc.soap.beans.RemotePermissionMapping.html%22%2c%22cob-rep%5c%2fhtml%5c%2fcom.atlassian.jira.rpc.soap.beans.RemotePermissionScheme.html%22%2c%22cob-rep%5c%2fhtml%5c%2fcom.atlassian.jira.rpc.soap.beans.RemotePriority.html%22%2c%22cob-rep%5c%2fhtml%5c%2fcom.atlassian.jira.rpc.soap.beans.RemoteProject.html%22%2c%22cob-rep%5c%2fhtml%5c%2fcom.atlassian.jira.rpc.soap.beans.RemoteProjectRole.html%22%2c%22cob-rep%5c%2fhtml%5c%2fcom.atlassian.jira.rpc.soap.beans.RemoteProjectRoleActors.html%22%2c%22cob-rep%5c%2fhtml%5c%2fcom.atlassian.jira.rpc.soap.beans.RemoteResolution.html%22%2c%22cob-rep%5c%2fhtml%5c%2fcom.atlassian.jira.rpc.soap.beans.RemoteRoleActor.html%22%2c%22cob-rep%5c%2fhtml%5c%2fcom.atlassian.jira.rpc.soap.beans.RemoteRoleActors.html%22%2c%22cob-rep%5c%2fhtml%5c%2fcom.atlassian.jira.rpc.soap.beans.RemoteScheme.html%22%2c%22cob-rep%5c%2fhtml%5c%2fcom.atlassian.jira.rpc.soap.beans.RemoteSecurityLevel.html%22%2c%22cob-rep%5c%2fhtml%5c%2fcom.atlassian.jira.rpc.soap.beans.RemoteServerInfo.html%22%2c%22cob-rep%5c%2fhtml%5c%2fcom.atlassian.jira.rpc.soap.beans.RemoteStatus.html%22%2c%22cob-rep%5c%2fhtml%5c%2fcom.atlassian.jira.rpc.soap.beans.RemoteTimeInfo.html%22%2c%22cob-rep%5c%2fhtml%5c%2fcom.atlassian.jira.rpc.soap.beans.RemoteUser.html%22%2c%22cob-rep%5c%2fhtml%5c%2fcom.atlassian.jira.rpc.soap.beans.RemoteVersion.html%22%2c%22cob-rep%5c%2fhtml%5c%2fcom.atlassian.jira.rpc.soap.beans.RemoteWorklog.html%22%2c%22cob-rep%5c%2fhtml%5c%2fcss%5c%2fhelp.css%22%2c%22cob-rep%5c%2fhtml%5c%2fcss%5c%2fmain.css%22%2c%22cob-rep%5c%2fhtml%5c%2fcss%5c%2fsortabletable.css%22%2c%22cob-rep%5c%2fhtml%5c%2fcss%5c%2fsource-viewer.css%22%2c%22cob-rep%5c%2fhtml%5c%2fcss%5c%2ftooltip.css%22%2c%22cob-rep%5c%2fhtml%5c%2fde.angelcode.rpc.soap.service.JiraClient.html%22%2c%22cob-rep%5c%2fhtml%5c%2fde.angelcode.rpc.soap.service.JiraClientImpl.html%22%2c%22cob-rep%5c%2fhtml%5c%2fde.angelcode.rpc.soap.service.JiraSoapService.html%22%2c%22cob-rep%5c%2fhtml%5c%2fde.angelcode.rpc.soap.service.JiraSoapServiceProxy.html%22%2c%22cob-rep%5c%2fhtml%5c%2fde.angelcode.rpc.soap.service.JiraSoapServiceService.html%22%2c%22cob-rep%5c%2fhtml%5c%2fde.angelcode.rpc.soap.service.JiraSoapServiceServiceLocator.html%22%2c%22cob-rep%5c%2fhtml%5c%2fde.angelcode.rpc.soap.service.JirasoapserviceV2SoapBindingStub.html%22%2c%22cob-rep%5c%2fhtml%5c%2fde.fhb.jirgit.exception.JIRAException.html%22%2c%22cob-rep%5c%2fhtml%5c%2fde.fhb.jirgit.exception.NoValidLoginException.html%22%2c%22cob-rep%5c%2fhtml%5c%2fde.fhb.jirgit.exception.VoidParameterException.html%22%2c%22cob-rep%5c%2fhtml%5c%2fframe-packages.html%22%2c%22cob-rep%5c%2fhtml%5c%2fframe-sourcefiles-com.atlassian.jira.rpc.exception.html%22%2c%22cob-rep%5c%2fhtml%5c%2fframe-sourcefiles-com.atlassian.jira.rpc.soap.beans.html%22%2c%22cob-rep%5c%2fhtml%5c%2fframe-sourcefiles-de.angelcode.rpc.soap.service.html%22%2c%22cob-rep%5c%2fhtml%5c%2fframe-sourcefiles-de.fhb.jirgit.exception.html%22%2c%22cob-rep%5c%2fhtml%5c%2fframe-sourcefiles.html%22%2c%22cob-rep%5c%2fhtml%5c%2fframe-summary-com.atlassian.jira.rpc.exception.html%22%2c%22cob-rep%5c%2fhtml%5c%2fframe-summary-com.atlassian.jira.rpc.soap.beans.html%22%2c%22cob-rep%5c%2fhtml%5c%2fframe-summary-de.angelcode.rpc.soap.service.html%22%2c%22cob-rep%5c%2fhtml%5c%2fframe-summary-de.fhb.jirgit.exception.html%22%2c%22cob-rep%5c%2fhtml%5c%2fframe-summary.html%22%2c%22cob-rep%5c%2fhtml%5c%2fhelp.html%22%2c%22cob-rep%5c%2fhtml%5c%2fimages%5c%2fblank.png%22%2c%22cob-rep%5c%2fhtml%5c%2fimages%5c%2fdownsimple.png%22%2c%22cob-rep%5c%2fhtml%5c%2fimages%5c%2fupsimple.png%22%2c%22cob-rep%5c%2fhtml%5c%2findex.html%22%2c%22cob-rep%5c%2fhtml%5c%2fjs%5c%2fcustomsorttypes.js%22%2c%22cob-rep%5c%2fhtml%5c%2fjs%5c%2fpopup.js%22%2c%22cob-rep%5c%2fhtml%5c%2fjs%5c%2fsortabletable.js%22%2c%22cob-rep%5c%2fhtml%5c%2fjs%5c%2fstringbuilder.js%22%2c%22cobertura.ser%22%2c%22lib%5c%2fcglib-2.2.jar%22%2c%22lib%5c%2fobjenesis-1.2.jar%22%2c%22src%5c%2fde%5c%2ffhb%5c%2fjirgit%5c%2fexception%5c%2fJIRAException.java%22%2c%22src%5c%2fde%5c%2ffhb%5c%2fjirgit%5c%2fexception%5c%2fNoValidLoginException.java%22%2c%22src%5c%2fde%5c%2ffhb%5c%2fjirgit%5c%2fexception%5c%2fVoidParameterException.java%22%5d%2c%22url%22%3a%22https%3a%5c%2f%5c%2fgithub.com%5c%2fbennyn%5c%2fJIR-Git%5c%2fcommit%5c%2f959e5fce4b781084cbd302c65e27f0dcf7abd881%22%2c%22removed%22%3a%5b%5d%2c%22message%22%3a%22add%20some%20tests%20for%20login%22%2c%22modified%22%3a%5b%22.classpath%22%2c%22.settings%5c%2forg.eclipse.core.resources.prefs%22%2c%22classes%5c%2fde%5c%2fangelcode%5c%2frpc%5c%2fsoap%5c%2fservice%5c%2fJiraClient.class%22%2c%22classes%5c%2fde%5c%2fangelcode%5c%2frpc%5c%2fsoap%5c%2fservice%5c%2fJiraClientImpl.class%22%2c%22classes%5c%2fde%5c%2fangelcode%5c%2frpc%5c%2fsoap%5c%2fservice%5c%2fJiraClientImplTest.class%22%2c%22reports%5c%2fhtml%5c%2fall-tests.html%22%2c%22reports%5c%2fhtml%5c%2falltests-errors.html%22%2c%22reports%5c%2fhtml%5c%2fde%5c%2fangelcode%5c%2frpc%5c%2fsoap%5c%2fservice%5c%2f0_JiraClientImplTest.html%22%2c%22reports%5c%2fhtml%5c%2fde%5c%2fangelcode%5c%2frpc%5c%2fsoap%5c%2fservice%5c%2fpackage-summary.html%22%2c%22reports%5c%2fhtml%5c%2foverview-summary.html%22%2c%22reports%5c%2fxml%5c%2fTEST-de.angelcode.rpc.soap.service.JiraClientImplTest.xml%22%2c%22reports%5c%2fxml%5c%2fTESTS-TestSuites.xml%22%2c%22src%5c%2fde%5c%2fangelcode%5c%2frpc%5c%2fsoap%5c%2fservice%5c%2fJiraClient.java%22%2c%22src%5c%2fde%5c%2fangelcode%5c%2frpc%5c%2fsoap%5c%2fservice%5c%2fJiraClientImpl.java%22%2c%22test%5c%2fde%5c%2fangelcode%5c%2frpc%5c%2fsoap%5c%2fservice%5c%2fJiraClientImplTest.java%22%5d%2c%22id%22%3a%22959e5fce4b781084cbd302c65e27f0dcf7abd881%22%7d%5d%2c%22ref%22%3a%22refs%5c%2fheads%5c%2fmaster%22%2c%22forced%22%3afalse%2c%22compare%22%3a%22https%3a%5c%2f%5c%2fgithub.com%5c%2fbennyn%5c%2fJIR-Git%5c%2fcompare%5c%2f6b9ef66...959e5fc%22%2c%22before%22%3a%226b9ef669396b5747d53cf11bb6443bd7c84810e3%22%2c%22after%22%3a%22959e5fce4b781084cbd302c65e27f0dcf7abd881%22%2c%22repository%22%3a%7b%22has_wiki%22%3atrue%2c%22url%22%3a%22https%3a%5c%2f%5c%2fgithub.com%5c%2fbennyn%5c%2fJIR-Git%22%2c%22open_issues%22%3a0%2c%22watchers%22%3a1%2c%22description%22%3a%22%22%2c%22fork%22%3atrue%2c%22pushed_at%22%3a%222010%2f12%2f01%2006%3a30%3a19%20-0800%22%2c%22has_issues%22%3afalse%2c%22private%22%3afalse%2c%22forks%22%3a0%2c%22created_at%22%3a%222010%2f12%2f06%2020%3a43%3a33%20-0800%22%2c%22has_downloads%22%3atrue%2c%22owner%22%3a%7b%22email%22%3a%22bn%40bennyn.de%22%2c%22name%22%3a%22bennyn%22%7d%2c%22name%22%3a%22JIR-Git%22%2c%22homepage%22%3a%22%22%7d%7d";
    JiraServiceHook hook = new JiraServiceHook(json1);
    //System.out.println(hook);
    JiraController controller = new JiraController();
    controller.loadConfigFile();
  }
}
