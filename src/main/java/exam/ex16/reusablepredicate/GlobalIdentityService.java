package exam.ex16.reusablepredicate;

public interface GlobalIdentityService {

    String getViewerIdentity(String userId);
    String getEditorIdentity(String userId);
    String getAdminIdentity(String userId);
}