import { useCallback, useState } from "react";
import styled from "styled-components";
import Tag from "./Tag";

function Tags({hashTags, setHashTags}) {
    const [value, setValue] = useState(null);
    const handler = useCallback((e) => {
        setValue(e.target.value);
    }, []);

    const onEnter = (e) => {
        if(e.key === 'Enter') {
            if(hashTags.indexOf(value) < 0) {
                setHashTags([...hashTags, value]);
            }
            setValue('');
        }
    }

    const removeTag = (e) => {
        const idx = hashTags.indexOf(e.target.innerHTML);
        hashTags.splice(idx, 1);
        setHashTags([...hashTags]);
    }

    return (
        <StyledTags>
            {hashTags.map((tag, idx) => {
                return (
                    <Tag idx={idx} removeTag={removeTag}>
                        {tag}
                    </Tag>
                );
            })}
        
            <StyledInput 
                type="text" 
                placeholder="태그를 입력하세요" 
                onKeyPress={onEnter} 
                onChange={handler} 
                value={value || ''} 
            />
        </StyledTags>
    );
}

const StyledTags = styled.div`
    display: flex;
    align-items: center;
    justify-content: space-between;
    flex-wrap: wrap;
    justify-content: flex-start;
    background-color: #fff;
    height: 20%;
`;

const StyledInput = styled.input`
    outline: none;
    border: none;
    line-height: 1.5rem;
    font-size: 1.1rem;
`;

export default Tags;
