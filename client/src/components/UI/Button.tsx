import React, {FC} from 'react';

interface ButtonProps {
    children: any;
    className?: string;
    type?: "button" | "submit"
    value?: string
    onClick?: any
}

const Button: FC<ButtonProps> = ({className, children, ...props}) => {
    const rootClasses = "px-6 py-2 text-sm self-center cursor-pointer rounded dark:text-slate-200 " + className
    return (
        <button className={rootClasses} {...props}>
            {children}
        </button>
    );
}

export default Button;