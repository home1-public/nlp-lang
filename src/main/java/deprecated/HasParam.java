package deprecated;

@Deprecated
public interface HasParam<P> {

    P getParam();

    void setParam(P param);
}
