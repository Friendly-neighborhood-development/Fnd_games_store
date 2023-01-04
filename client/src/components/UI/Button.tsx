import React, {FC} from 'react';

interface ButtonProps {
    children: any;
    className?: string;
    type?: "button" | "submit"
    value?: string
    onClick?: any
}

const Button: FC<ButtonProps> = ({className, children, ...props}) => {
    const rootClasses = "px-6 lg:py-2 py-3 text-sm self-center cursor-pointer rounded capitalize " + className
    return (
        <button className={rootClasses} {...props}>
            {children}
        </button>
    );
}

export default Button;