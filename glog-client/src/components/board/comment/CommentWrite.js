import styled from "styled-components";

function CommentWrite(props) {
    //value={comment} onChagneComent={onChagneComent} goComment={goComment}
    const { value, _onChange, _onClick, type } = props;

    return (
        <StyledCommentWrite>
            <textarea value={value} placeholder="댓글 작성해주세요." onChange={_onChange}></textarea>
            <StyledButtons>
                <button className="submit" onClick={_onClick}>
                    {type === 'change' ? '댓글 수정' : '댓글 작성'}
                </button>
            </StyledButtons>
        </StyledCommentWrite>
    );
}
const StyledCommentWrite = styled.div`
    margin-bottom: 3rem;
    textarea {
        width: 100%;
        box-sizing: border-box;
        resize: none;
        outline: none;
        border: 1px solid rgb(233, 236, 239);
        border-radius: 0.4rem;
        min-height: 6.125rem;
        color: rgb(33, 37, 41);
        line-height: 1.75;
        margin-bottom: 2rem;
        padding: 1rem 1rem 1.5rem;
    }
`;
const StyledButtons = styled.div`
    display: flex;
    justify-content: flex-end;
    button {
        display: flex;
        align-items: center;
        justify-content: center;
        font-weight: 600;
        background-color: #a680d2;
        border: none;
        color: #fff;
        padding: 0.5rem 1rem;
        border-radius: 0.3rem;
    }
`;

export default CommentWrite;