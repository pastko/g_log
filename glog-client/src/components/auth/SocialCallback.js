import { useEffect, useState } from "react";
import AuthForm from "./AuthForm";
import { actionCreators as userActions } from '../../store/reducer/users';
import { useSelector, useDispatch } from "react-redux";

function SocialCallback({ authURI, nowURL }) {
  const dispatch = useDispatch();
  const [isLogin, setIsLogin] = useState(useSelector((state) => state.user.is_login));
  const history = useSelector((state) => state.router);

  console.log("socaicallback");
  console.log(nowURL);
  debugger;
  useEffect(() => {
    const getToken = async () => {
      console.log("oauth login");
      const authorizationCode = nowURL.searchParams.get("code");
      dispatch(userActions.googleOAuthSignInAPI(authorizationCode));

    };
    getToken();
  }, [authURI, nowURL]);

  return (
    <>
      {isLogin ? (
        // <Header />
        history.push('/')
      ) : (
        <AuthForm isLoginFailed />
      )}
    </>
  );
}

export default SocialCallback;
