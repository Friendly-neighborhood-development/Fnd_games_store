import React, {FC, memo} from 'react';

const Sidebar: FC = memo(() => {
    return (
        <div className={"hidden lg:block sticky top-24 w-56 bg-white h-96 rounded-lg"}>
            Sidebar
        </div>
    );
});

export default Sidebar;