import styled from "styled-components";
import CommentItems from "./CommentItems";
import CommentWrite from "./CommentWrite";


function Comment() {

    return (
        <SytledComment>
            <h3>0개의 댓글</h3>
            <CommentWrite />
            <StyledCommmentList>
                <CommentItems />
            </StyledCommmentList>
        </SytledComment>
    );
}

const SytledComment = styled.div`

`;

const StyledCommmentList = styled.div`

`;

export default Comment;