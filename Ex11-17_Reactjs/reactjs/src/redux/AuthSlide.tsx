import { createSlice } from "@reduxjs/toolkit"


export interface initialStateType {

    token: string
};

const initialState: initialStateType = {
    token: 'dfsadf'
};

const authSlide = createSlice({
    name: 'auth',
    initialState,
    reducers: {
        loginSuccess(state, aciton) {
            state.token = aciton.payload.token;
        }
    }
});

const { actions, reducer } = authSlide;
export const { loginSuccess } = actions;
export default reducer;
