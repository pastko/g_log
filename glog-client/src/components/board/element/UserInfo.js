import styled from "styled-components";
import Images from "../../layout/Images";
import testImg from '../../../img/test.jpg';
import { Link } from "react-router-dom";

function UserInfo() {
    return (
        <Block>
            <StyledUserInfo>
                {/* <Images src="" width={ } height={ } shape="circle" /> */}
                <Link to="">
                    <img src={testImg} width={128} height={128} alt="test" />
                    <div className="userInfo">
                        <span className="name">hwlee-study</span>
                        <span className="intro">예제 입니다.</span>
                    </div>
                </Link>
            </StyledUserInfo>
            <div className="line"></div>
        </Block>
    );
}
const Block = styled.div`
    max-width: 768px;
    margin: 0 auto;
    .line {
        background: rgb(233, 236, 239);
        width: 100%;
        height: 1px;
        margin-top: 2rem;
        margin-bottom: 3rem;
    }  
`;
const StyledUserInfo = styled.div`
    margin-top: 5.625rem;
    display: flex;
    align-items: center;
    img {
        display: inline-block;
    }
    .userInfo {
        display: inline-block;
        text-align: left;
        margin-left: 1rem;
        .name {
            font-size: 1.5rem;
            line-height: 1.5;
            font-weight: 600;
            margin-right: 10px;
        }
        .intro {
            display: block;
        }
    }
`;

export default UserInfo;