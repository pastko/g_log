import styled from "styled-components";
import Button from "../layout/Button";

function UserInfo({ title, contents, isButton, description }) {
    return (
        <StyledUserInfo>
            <StyledInfoWrap>
                <StyledTitle>{title}</StyledTitle>
                {contents && <StyledContent>{contents}</StyledContent>}
                {isButton === '회원 탈퇴' ? (
                    <Button isRed _onClick="">
                        {isButton}
                    </Button>
                ) : (
                    <Button isDefault _onClick="">
                        {isButton}
                    </Button>
                )}
            </StyledInfoWrap>
            {description && (
                <StyledDescription>{description}</StyledDescription>
            )}
        </StyledUserInfo>
    );
}
const StyledUserInfo = styled.div`
    padding: 1rem 0;
    border-bottom: 1px solid rgb(223, 236, 239);
`;
const StyledInfoWrap = styled.div`
    display: flex;
    align-items: center;
    text-align: left;
`;
const StyledTitle = styled.h3`
    width: 9.5rem;
    line-height: 1.5;
    color: rgb(52, 58, 64);
    margin: 0px;
    font-size: 1.125rem;
    font-weight: 700;
`;
const StyledContent = styled.div`
    flex: 1 1 0%;
    font-size: 1rem;
    color: rgb(73, 80, 87);
    line-height: 1.5;
`;
const StyledDescription = styled.div`
    text-align: left;
    margin-top: 0.875rem;
    color: rgb(134, 142, 150);
    font-size: 0.875rem;
`;
export default UserInfo;