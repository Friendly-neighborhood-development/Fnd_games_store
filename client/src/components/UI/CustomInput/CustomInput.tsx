import React, {FC} from 'react';

import cl from "./CustomInput.module.css";

interface CustomInputProps{
    value?: string | number;
    onChange?: () => void;
    type: string;
    placeholder?: string;

}

const CustomInput:FC<CustomInputProps> = (props) => {
    return <input className={cl.input} {...props} />;
}

export default CustomInput;