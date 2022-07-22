import React, {FC} from 'react';

interface CustomButtonProps {
    children: any;
}

const CustomButton: FC<CustomButtonProps> = ({children}) => {
    return (
        <button
            className={"px-6 py-3 self-center cursor-pointer bg-white text-blue-600 rounded-lg border-solid" +
                " border-blue-600 border font-semibold hover:bg-blue-600 hover:text-white ease-in duration-200"}>
            {children}
        </button>
    );
}

export default CustomButton;